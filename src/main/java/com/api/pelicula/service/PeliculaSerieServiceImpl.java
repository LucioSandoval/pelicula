package com.api.pelicula.service;

import com.api.pelicula.common.mapper.MapearDtoAEntity;
import com.api.pelicula.common.mapper.MapearEntityADto;
import com.api.pelicula.model.dto.peliculaserie.DetallePeliculaSerieDto;
import com.api.pelicula.model.dto.peliculaserie.ListarPeliculaSerieDto;
import com.api.pelicula.model.dto.peliculaserie.PeliculaSerieDto;
import com.api.pelicula.model.entity.PeliculaSerieEntity;
import com.api.pelicula.model.projection.ListarPeliculaSerieProjection;
import com.api.pelicula.repository.PeliculaSerieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PeliculaSerieServiceImpl implements PeliculaSerieService{

    private final PeliculaSerieRepository peliculaSerieRepository;
    @Override
    public PeliculaSerieDto crearPeliculaSerie(PeliculaSerieDto peliculaSerieDto) {
        log.info("La peliculaSerieDto es: " + peliculaSerieDto.toString());
        PeliculaSerieEntity peliculaSerieEntity = MapearDtoAEntity.mapearPeliculaSerieDtoAEntity(peliculaSerieDto);
        peliculaSerieEntity = this.peliculaSerieRepository.save(peliculaSerieEntity);
        return MapearEntityADto.mapearPeliculaSerieEntityADto(peliculaSerieEntity);
    }

    @Override
    public PeliculaSerieDto actualizarPeliculaSerie(PeliculaSerieDto peliculaSerieDto) {
        log.info("La peliculaSerieDto es: " + peliculaSerieDto.toString());
        if(peliculaSerieDto == null){
            throw new IllegalStateException("El objeto peliculaSerieDto no puede ser nulo.");
        }
        PeliculaSerieEntity peliculaSerieEntity;
        peliculaSerieEntity = this.peliculaSerieRepository.findById(peliculaSerieDto.getId())
                .orElseThrow(() -> new IllegalStateException("No existe película o serie con el id " +
                        "[" +peliculaSerieDto.getId()+ "]"));
        peliculaSerieEntity.setImagen(peliculaSerieDto.getImagen());
        peliculaSerieEntity.setTitulo(peliculaSerieDto.getTitulo());
        peliculaSerieEntity.setCalificacion(peliculaSerieDto.getCalificacion());
        peliculaSerieEntity.setFechaModificacion(LocalDateTime.now());

        peliculaSerieEntity = this.peliculaSerieRepository.save(peliculaSerieEntity);
        return MapearEntityADto.mapearPeliculaSerieEntityADto(peliculaSerieEntity);
    }

    @Override
    public List<ListarPeliculaSerieDto> listarPeliculaSerie() {
        List<PeliculaSerieEntity>listaPeliculaSerie =
                this.peliculaSerieRepository.findByEliminadoFalse(PeliculaSerieEntity.class);
        //return listaPeliculaSerie.stream().map(MapearEntityADto::mapearListaPeliculaSerieEntityADto).collect(Collectors.toList());
        return listaPeliculaSerie.stream().map(peliculaSerieEntity ->
                MapearEntityADto.mapearListaPeliculaSerieEntityADto(peliculaSerieEntity)).collect(Collectors.toList());
    }

    @Override
    public List<ListarPeliculaSerieProjection> listarPeliculaSeries() {
        return this.peliculaSerieRepository.findByEliminadoFalse(ListarPeliculaSerieProjection.class);
    }

    @Override
    public void eliminarPeliculaSerie(Long id) {
        PeliculaSerieEntity peliculaSerieEntity = this.peliculaSerieRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("No existe película serie con el id " +"["+id+"]"));
        peliculaSerieEntity.setEliminado(Boolean.TRUE);
        this.peliculaSerieRepository.save(peliculaSerieEntity);
    }

    @Override
    public List<DetallePeliculaSerieDto> detallePeliculaSerie() {
        List<PeliculaSerieEntity> listaPeliculaSerie = this.peliculaSerieRepository.detallePeliculaSerie();
        return listaPeliculaSerie.stream().map(MapearEntityADto::mapearDetallePeliculaSerieEntityADto).collect(Collectors.toList());
    }

    @Override
    public List<PeliculaSerieDto> buscarPeliculaSeriePorNombre(String nombre) {
        List<PeliculaSerieEntity> listaPeliculaSerie = this.peliculaSerieRepository.findByEliminadoFalseAndTitulo(nombre);
        return listaPeliculaSerie.stream().map(MapearEntityADto::mapearPeliculaSerieEntityADto).collect(Collectors.toList());
    }

    @Override
    public List<DetallePeliculaSerieDto> buscarPeliculaSeriePorIdGenero(Long id) {
        if(id == null){
            throw new IllegalStateException("No existe un género con el id "
                    +"[" + id + "]");
        }

        List<PeliculaSerieEntity> listaPeliculaSerie = this.peliculaSerieRepository.findByEliminadoFalseAndGenerosEliminadoFalseAndGenerosId(id);
        return listaPeliculaSerie.stream()
                .map(MapearEntityADto::mapearDetallePeliculaSerieEntityADto).collect(Collectors.toList());
    }

    @Override
    public List<PeliculaSerieDto> listarPeliculaSeriePorOrden(String orden) {
        List<PeliculaSerieEntity> listaPeliculaSerie = null;
        Boolean eliminado = Boolean.FALSE;
        if(orden.equalsIgnoreCase("desc")){
            listaPeliculaSerie = this.peliculaSerieRepository.findByEliminadoFalseOrderByFechaCreacionDesc();
        }else if(orden.equalsIgnoreCase("asc")){
            listaPeliculaSerie = this.peliculaSerieRepository.findByEliminadoFalseOrderByFechaCreacionAsc();
        }else{
            new IllegalStateException("Error en el parámetro orden listar pelicula serie asc, desc");
        }
        return listaPeliculaSerie.stream().map(MapearEntityADto::mapearPeliculaSerieEntityADto).collect(Collectors.toList());
    }


}

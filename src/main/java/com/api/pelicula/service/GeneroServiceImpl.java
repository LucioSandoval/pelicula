package com.api.pelicula.service;

import com.api.pelicula.common.mapper.MapearDtoAEntity;
import com.api.pelicula.common.mapper.MapearEntityADto;
import com.api.pelicula.model.dto.genero.GeneroDto;
import com.api.pelicula.model.entity.GeneroEntity;
import com.api.pelicula.repository.GeneroRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class GeneroServiceImpl implements GeneroService{
    private final GeneroRepository generoRepository;

    @Override
    public GeneroDto crearGenero(GeneroDto generoDto) {
        GeneroEntity generoEntity = MapearDtoAEntity.mapearGeneroDtoAEntity(generoDto);
        generoEntity = this.generoRepository.save(generoEntity);

        return MapearEntityADto.mapearGeneroEntityADto(generoEntity);
    }

    @Override
    public GeneroDto actualizarGenero(GeneroDto generoDto) {
        if (generoDto == null) {
            throw new IllegalArgumentException("El objeto generoDto no puede ser nulo.");
        }


        GeneroEntity generoEntity;
        generoEntity = this.generoRepository.findById(generoDto.getId())
                .orElseThrow(() -> new IllegalStateException("No existe un género con el id " +"["+generoDto.getId()+"]"));

        generoEntity.setNombre(generoDto.getNombre());
        generoEntity.setImagen(generoDto.getImagen());

        generoEntity = this.generoRepository.save(generoEntity);

        return MapearEntityADto.mapearGeneroEntityADto(generoEntity);
    }

    @Override
    public List<GeneroDto> listarGenero() {
        List<GeneroEntity> listaGenero = this.generoRepository.findByEliminadoFalse();
        return listaGenero.stream().map(MapearEntityADto::mapearGeneroEntityADto).collect(Collectors.toList());
    }

    @Override
    public void eliminarGenero(Long id) {
        GeneroEntity generoEntity = this.generoRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("No existe un género con el id " +"["+id+"]"));
        generoEntity.setEliminado(Boolean.TRUE);
        this.generoRepository.save(generoEntity);

    }
}

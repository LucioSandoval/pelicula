package com.api.pelicula.service;


import com.api.pelicula.common.mapper.MapearDtoAEntity;
import com.api.pelicula.common.mapper.MapearEntityADto;
import com.api.pelicula.model.dto.personaje.ListarDetallePersonajeDto;
import com.api.pelicula.model.dto.personaje.ListarPersonajeDto;
import com.api.pelicula.model.dto.personaje.PersonajeDto;
import com.api.pelicula.model.entity.PersonajeEntity;
import com.api.pelicula.model.projection.ListarPersonajeProjection;
import com.api.pelicula.repository.PersonajeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonajeServiceImpl implements PersonajeService{
    private  final PersonajeRepository personajeRepository;

    @Override
    public PersonajeDto crearPersonaje(PersonajeDto personajeDto) {
        PersonajeEntity personajeEntity = MapearDtoAEntity.mapearPersonajeDtoAEntity(personajeDto);
        personajeEntity = this.personajeRepository.save(personajeEntity);
        return MapearEntityADto.mapearPersonajeEntityADto(personajeEntity);
    }

    @Override
    public PersonajeDto actualizarPersonaje(PersonajeDto personajeDto) {
        if(personajeDto == null){
            throw new IllegalArgumentException("El objeto personajeDto no puede ser nulo.");
        }
        PersonajeEntity personajeEntity;
        personajeEntity = this.personajeRepository.findById(personajeDto.getId())
                .orElseThrow(() -> new IllegalStateException("No existe un personaje con el id "
                        +"[" + personajeDto.getId() + "]"));

        personajeEntity.setImagen(personajeDto.getImagen());
        personajeEntity.setNombre(personajeDto.getNombre());
        personajeEntity.setEdad(personajeDto.getEdad());
        personajeEntity.setPeso(personajeDto.getPeso());
        personajeEntity.setHistoria(personajeDto.getHistoria());
        personajeEntity = this.personajeRepository.save(personajeEntity);
        return MapearEntityADto.mapearPersonajeEntityADto(personajeEntity);
    }

    @Override
    public List<ListarPersonajeDto> listarPersonaje() {

        List<PersonajeEntity> listaPersonaje = this.personajeRepository.findByEliminadoFalse(PersonajeEntity.class);

        return listaPersonaje.stream().map( personajeEntity -> MapearEntityADto.mapearListaPersonajeEntityADto(personajeEntity)).collect(Collectors.toList());
    }

    @Override
    public List<ListarPersonajeProjection> listarPersonajes() {
        return  this.personajeRepository.findByEliminadoFalse(ListarPersonajeProjection.class);
    }

    @Override
    public void eliminarPersonaje(Long id) {
        PersonajeEntity personajeEntity;
        personajeEntity = this.personajeRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("No existe un personaje con el id "
                        +"[" + id + "]"));
        personajeEntity.setEliminado(Boolean.TRUE);
        this.personajeRepository.save(personajeEntity);

    }

    @Override
    public List<ListarDetallePersonajeDto> detallePersonaje() {
        List<PersonajeEntity> listaPersonaje = this.personajeRepository.findBy();
        return listaPersonaje.stream().map(MapearEntityADto::mapearListaDetallePersonajeEntityADto).collect(Collectors.toList());
    }

    @Override
    public List<PersonajeDto> buscarPersonajePorNombre(String nombre) {
        List<PersonajeEntity> listaPersonaje =
                this.personajeRepository.findByEliminadoFalseAndNombre(nombre);
        return listaPersonaje.stream().map(personajeEntity ->
                MapearEntityADto.mapearPersonajeEntityADto(personajeEntity)).collect(Collectors.toList());
    }

    @Override
    public List<PersonajeDto> buscarPersonajePorEdad(Integer edad) {
        List<PersonajeEntity> listaPersonaje =
                this.personajeRepository.findByEliminadoFalseAndEdad(edad);
        return listaPersonaje.stream().map(personajeEntity ->
                MapearEntityADto.mapearPersonajeEntityADto(personajeEntity)).collect(Collectors.toList());
    }

    @Override
    public List<ListarDetallePersonajeDto> buscarPersonajePorIdPeliculaSerie(Long id) {
        if(id == null){
           throw new IllegalStateException("No existe película serie con el id "
                   +"[" + id + "]");
        }
        List<PersonajeEntity> listaPersonaje =
                this.personajeRepository.findByEliminadoFalseAndPeliculasSeriesEliminadoFalseAndPeliculasSeriesId(id);
        return listaPersonaje.stream()
                .map(MapearEntityADto::mapearListaDetallePersonajeEntityADto).collect(Collectors.toList());
    }



}

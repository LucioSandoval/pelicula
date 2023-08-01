package com.api.pelicula.common.mapper;

import com.api.pelicula.model.dto.genero.GeneroDto;
import com.api.pelicula.model.dto.peliculaserie.PeliculaSerieDto;
import com.api.pelicula.model.dto.personaje.PersonajeDto;
import com.api.pelicula.model.entity.GeneroEntity;
import com.api.pelicula.model.entity.PeliculaSerieEntity;
import com.api.pelicula.model.entity.PersonajeEntity;

import java.time.LocalDateTime;

public abstract class MapearDtoAEntity {

    public static PersonajeEntity mapearPersonajeDtoAEntity(PersonajeDto personajeDto) {
        if(personajeDto == null){
            throw new IllegalArgumentException("El objeto personajeDto no puede ser nulo.");
        }
            PersonajeEntity personajeEntity = new PersonajeEntity();
            personajeEntity.setId(personajeDto.getId());
            personajeEntity.setImagen(personajeDto.getImagen());
            personajeEntity.setNombre(personajeDto.getNombre());
            personajeEntity.setEdad(personajeDto.getEdad());
            personajeEntity.setPeso(personajeDto.getPeso());
            personajeEntity.setHistoria(personajeDto.getHistoria());
            personajeEntity.setEliminado(Boolean.FALSE);
            return personajeEntity;
    }

    public static PeliculaSerieEntity mapearPeliculaSerieDtoAEntity(PeliculaSerieDto peliculaSerieDto) {
        if(peliculaSerieDto == null){
            throw new IllegalArgumentException("El objeto peliculaSerieDto no puede ser nulo.");
        }
        PeliculaSerieEntity peliculaSerieEntity = new PeliculaSerieEntity();

        peliculaSerieEntity.setId(peliculaSerieDto.getId());
        peliculaSerieEntity.setImagen(peliculaSerieDto.getImagen());
        peliculaSerieEntity.setTitulo(peliculaSerieDto.getTitulo());
        peliculaSerieEntity.setCalificacion(peliculaSerieDto.getCalificacion());
        peliculaSerieEntity.setEliminado(Boolean.FALSE);
        peliculaSerieEntity.setFechaCreacion(LocalDateTime.now());
        return peliculaSerieEntity;

    }

    public static GeneroEntity mapearGeneroDtoAEntity(GeneroDto generoDto) {
        if (generoDto == null) {
            throw new IllegalArgumentException("El objeto GeneroDto no puede ser nulo.");
        }
            GeneroEntity generoEntity = new GeneroEntity();
            generoEntity.setId(generoDto.getId());
            generoEntity.setNombre(generoDto.getNombre());
            generoEntity.setImagen(generoDto.getImagen());
            generoEntity.setEliminado(generoDto.getEliminado());
            return generoEntity;
    }
}

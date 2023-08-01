package com.api.pelicula.common.mapper;

import com.api.pelicula.model.dto.genero.GeneroDto;
import com.api.pelicula.model.dto.peliculaserie.DetallePeliculaSerieDto;
import com.api.pelicula.model.dto.peliculaserie.ListarPeliculaSerieDto;
import com.api.pelicula.model.dto.personaje.ListarDetallePersonajeDto;
import com.api.pelicula.model.dto.personaje.ListarPersonajeDto;
import com.api.pelicula.model.dto.peliculaserie.PeliculaSerieDto;
import com.api.pelicula.model.dto.personaje.PersonajeDto;
import com.api.pelicula.model.entity.GeneroEntity;
import com.api.pelicula.model.entity.PeliculaSerieEntity;
import com.api.pelicula.model.entity.PersonajeEntity;

import java.util.List;
import java.util.stream.Collectors;

public abstract class MapearEntityADto {

    public static PersonajeDto mapearPersonajeEntityADto(PersonajeEntity personajeEntity) {
        if(personajeEntity == null){
            throw new IllegalArgumentException("El objeto personajeEntity no puede ser nulo.");
        }
                return PersonajeDto.builder()
                        .id(personajeEntity.getId())
                        .imagen(personajeEntity.getImagen())
                        .nombre(personajeEntity.getNombre())
                        .edad(personajeEntity.getEdad())
                        .peso(personajeEntity.getPeso())
                        .historia(personajeEntity.getHistoria())
                        .eliminado(personajeEntity.getEliminado())
                        .build();
    }

    public static PeliculaSerieDto mapearPeliculaSerieEntityADto(PeliculaSerieEntity peliculaSerieEntity) {
        if(peliculaSerieEntity == null){
            throw new IllegalArgumentException("El objeto peliculaSerieEntity no puede ser nulo.");
        }
                return PeliculaSerieDto.builder()
                        .id(peliculaSerieEntity.getId())
                        .imagen(peliculaSerieEntity.getImagen())
                        .titulo(peliculaSerieEntity.getTitulo())
                        .calificacion(peliculaSerieEntity.getCalificacion())
                        .eliminado(peliculaSerieEntity.getEliminado())
                        .fechaCreacion(peliculaSerieEntity.getFechaCreacion())
                        .build();
    }

    public static ListarPersonajeDto mapearListaPersonajeEntityADto(PersonajeEntity personajeEntity) {
        if (personajeEntity == null) {
            throw new IllegalArgumentException("La entidad PersonajeEntity no puede ser nula.");
        }
        return
                ListarPersonajeDto.builder()
                .imagen(personajeEntity.getImagen())
                .nombre(personajeEntity.getNombre())
                .build();
    }

    public static ListarPeliculaSerieDto mapearListaPeliculaSerieEntityADto(PeliculaSerieEntity peliculaSerieEntity) {
        if(peliculaSerieEntity == null){
            throw new IllegalArgumentException("El objeto peliculaSerieEntity no puede ser nulo.");
        }
                return ListarPeliculaSerieDto.builder()
                        .id(peliculaSerieEntity.getId())
                        .imagen(peliculaSerieEntity.getImagen())
                        .titulo(peliculaSerieEntity.getTitulo())
                        .fechaCreacion(peliculaSerieEntity.getFechaCreacion())
                        .build();
    }

    public static ListarDetallePersonajeDto mapearListaDetallePersonajeEntityADto(PersonajeEntity personajeEntity) {
        if(personajeEntity == null){
            throw new IllegalArgumentException("El objeto personajeEntity no puede ser nulo.");
        }
        List<PeliculaSerieEntity> listaPerliculaSerie = personajeEntity.getPeliculasSeries();

                return ListarDetallePersonajeDto.builder()
                        .id(personajeEntity.getId())
                        .imagen(personajeEntity.getImagen())
                        .nombre(personajeEntity.getNombre())
                        .edad(personajeEntity.getEdad())
                        .peso(personajeEntity.getPeso())
                        .historia(personajeEntity.getHistoria())
                        .eliminado(personajeEntity.getEliminado())
                        .peliculasSeries(listaPerliculaSerie.stream().map(MapearEntityADto::mapearPeliculaSerieEntityADto)
                                .collect(Collectors.toList()))
                        .build();
    }

    public static DetallePeliculaSerieDto mapearDetallePeliculaSerieEntityADto(PeliculaSerieEntity peliculaSerieEntity) {
        if(peliculaSerieEntity == null){
            throw new IllegalArgumentException("El objeto peliculaSerieEntity no puede ser nulo.");
        }
        List<PersonajeEntity> listaPersonaje = peliculaSerieEntity.getPersonajes();

                return DetallePeliculaSerieDto.builder()
                        .id(peliculaSerieEntity.getId())
                        .imagen(peliculaSerieEntity.getImagen())
                        .titulo(peliculaSerieEntity.getTitulo())
                        .calificacion(peliculaSerieEntity.getCalificacion())
                        .fechaCreacion(peliculaSerieEntity.getFechaCreacion())
                        .eliminado(peliculaSerieEntity.getEliminado())
                        .listaPersonajeDto(listaPersonaje.stream().map(MapearEntityADto::mapearPersonajeEntityADto).collect(Collectors.toList()))
                        .build();
    }

    public static GeneroDto mapearGeneroEntityADto(GeneroEntity generoEntity) {
        if (generoEntity == null) {
            throw new IllegalArgumentException("El objeto generoEntity no puede ser nulo.");
        }
        return GeneroDto.builder()
                .id(generoEntity.getId())
                .imagen(generoEntity.getImagen())
                .nombre(generoEntity.getNombre())
                .eliminado(generoEntity.getEliminado())
                .build();
    }



}

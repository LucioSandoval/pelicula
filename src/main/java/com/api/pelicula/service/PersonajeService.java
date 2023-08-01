package com.api.pelicula.service;

import com.api.pelicula.model.dto.personaje.ListarDetallePersonajeDto;
import com.api.pelicula.model.dto.personaje.ListarPersonajeDto;
import com.api.pelicula.model.dto.personaje.PersonajeDto;
import com.api.pelicula.model.projection.ListarPersonajeProjection;

import java.util.List;

public interface PersonajeService {
    PersonajeDto crearPersonaje(PersonajeDto personajeDto);
    PersonajeDto actualizarPersonaje(PersonajeDto personajeDto);
    List<ListarPersonajeDto> listarPersonaje();
    List<ListarPersonajeProjection> listarPersonajes();
    void eliminarPersonaje(Long id);

    List<ListarDetallePersonajeDto> detallePersonaje();
    List<PersonajeDto> buscarPersonajePorNombre(String nombre);
    List<PersonajeDto> buscarPersonajePorEdad(Integer edad);
    List<ListarDetallePersonajeDto> buscarPersonajePorIdPeliculaSerie(Long id);
}

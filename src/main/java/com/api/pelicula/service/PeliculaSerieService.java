package com.api.pelicula.service;

import com.api.pelicula.model.dto.peliculaserie.DetallePeliculaSerieDto;
import com.api.pelicula.model.dto.peliculaserie.ListarPeliculaSerieDto;
import com.api.pelicula.model.dto.peliculaserie.PeliculaSerieDto;
import com.api.pelicula.model.projection.ListarPeliculaSerieProjection;

import java.util.List;

public interface PeliculaSerieService {
    PeliculaSerieDto crearPeliculaSerie(PeliculaSerieDto peliculaSerieDto);
    PeliculaSerieDto actualizarPeliculaSerie(PeliculaSerieDto peliculaSerieDto);
    List<ListarPeliculaSerieDto> listarPeliculaSerie();
    List<ListarPeliculaSerieProjection> listarPeliculaSeries();
    void eliminarPeliculaSerie(Long id);

    List<DetallePeliculaSerieDto> detallePeliculaSerie();

    List<PeliculaSerieDto> buscarPeliculaSeriePorNombre(String nombre);

    List<DetallePeliculaSerieDto> buscarPeliculaSeriePorIdGenero(Long id);

    List<PeliculaSerieDto> listarPeliculaSeriePorOrden(String orden);
}

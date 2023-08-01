package com.api.pelicula.service;

import com.api.pelicula.model.dto.genero.GeneroDto;

import java.util.List;

public interface GeneroService {

    GeneroDto crearGenero(GeneroDto generoDto);
    GeneroDto actualizarGenero(GeneroDto generoDto);
    List<GeneroDto> listarGenero();
    void eliminarGenero(Long id);
}

package com.api.pelicula.controller;

import com.api.pelicula.model.dto.genero.GeneroDto;
import com.api.pelicula.model.dto.peliculaserie.ListarPeliculaSerieDto;
import com.api.pelicula.service.GeneroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class GeneroController {

    private final GeneroService generoService;
    @PostMapping(value = "/crearGenero", consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GeneroDto> crearGenero(@RequestBody GeneroDto generoDto){
        return new ResponseEntity<>(this.generoService.crearGenero(generoDto), HttpStatus.CREATED);
    }
    @PutMapping(value = "/actualizarGenero", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GeneroDto> actualizarGenero(@RequestBody GeneroDto generoDto){
        return new ResponseEntity<>(this.generoService.actualizarGenero(generoDto), HttpStatus.OK);
    }
    @DeleteMapping(value = "/eliminarGenero")
    public ResponseEntity<?> eliminarPeliculaSerie(@RequestParam("id") Long id){
        this.generoService.eliminarGenero(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "listarGenero", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GeneroDto>> listarPeliculaSerie(){
        return new ResponseEntity<>(this.generoService.listarGenero(), HttpStatus.OK);
    }
}

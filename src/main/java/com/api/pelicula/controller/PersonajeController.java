package com.api.pelicula.controller;

import com.api.pelicula.model.dto.personaje.ListarDetallePersonajeDto;
import com.api.pelicula.model.dto.personaje.ListarPersonajeDto;
import com.api.pelicula.model.dto.personaje.PersonajeDto;
import com.api.pelicula.model.projection.ListarPersonajeProjection;
import com.api.pelicula.service.PersonajeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class PersonajeController {

    private final PersonajeService personajeService;
    @PostMapping(value = "/crearPersonaje", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonajeDto> crearPersonaje(@RequestBody PersonajeDto personajeDto){
        return new ResponseEntity<>(this.personajeService.crearPersonaje(personajeDto),HttpStatus.CREATED);
    }

    @PutMapping(value = "/actualizarPersonaje", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonajeDto> actualizarPersonaje(@RequestBody PersonajeDto personajeDto){
        return new ResponseEntity<>(this.personajeService.actualizarPersonaje(personajeDto),HttpStatus.OK);
    }

    @DeleteMapping(value = "/eliminarPersonaje")
    public ResponseEntity<?> eliminarPersonaje(@RequestParam("id") Long id){
        this.personajeService.eliminarPersonaje(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "listarPersonaje", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ListarPersonajeDto>> listarPersonaje(){
        return new ResponseEntity<>(this.personajeService.listarPersonaje(), HttpStatus.OK);
    }

    @GetMapping(value = "listarPersonajes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ListarPersonajeProjection>> listarPersonajes(){
        return new ResponseEntity<>(this.personajeService.listarPersonajes(), HttpStatus.OK);
    }

    @GetMapping(value = "detallePersonaje", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ListarDetallePersonajeDto>> detallePersonaje(){
        return new ResponseEntity<>(this.personajeService.detallePersonaje(), HttpStatus.OK);
    }

    @GetMapping(value = "buscarPersonajePorNombre", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PersonajeDto>> buscarPersonajePorNombre(@RequestParam("nombre") String nombre){
        return new ResponseEntity<>(this.personajeService.buscarPersonajePorNombre(nombre), HttpStatus.OK);
    }

    @GetMapping(value = "buscarPersonajePorEdad", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PersonajeDto>> buscarPersonajePorEdad(@RequestParam("edad") Integer edad){
        return new ResponseEntity<>(this.personajeService.buscarPersonajePorEdad(edad), HttpStatus.OK);
    }

    @GetMapping(value = "buscarPersonajePorIdPeliculaSerie", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ListarDetallePersonajeDto>> buscarPersonajePorIdPeliculaSerie(@RequestParam("id") Long id){
        return new ResponseEntity<>(this.personajeService.buscarPersonajePorIdPeliculaSerie(id), HttpStatus.OK);
    }

}

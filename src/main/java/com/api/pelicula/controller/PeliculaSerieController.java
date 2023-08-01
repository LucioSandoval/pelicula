package com.api.pelicula.controller;

import com.api.pelicula.model.dto.peliculaserie.DetallePeliculaSerieDto;
import com.api.pelicula.model.dto.peliculaserie.ListarPeliculaSerieDto;
import com.api.pelicula.model.dto.peliculaserie.PeliculaSerieDto;
import com.api.pelicula.model.projection.ListarPeliculaSerieProjection;
import com.api.pelicula.service.PeliculaSerieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class PeliculaSerieController {

    private final PeliculaSerieService peliculaSerieService;

    @PostMapping(value = "/crearPeliculaSerie", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> crearPeliculaSerie(@RequestBody PeliculaSerieDto peliculaSerieDto){

        try{
            return new ResponseEntity<>(this.peliculaSerieService.crearPeliculaSerie(peliculaSerieDto), HttpStatus.CREATED);
        }catch (IllegalStateException e){
            e.printStackTrace();
            return ResponseHandler.generarRespuesta(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseHandler.generarRespuesta(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Ha ocurrido un error al intentar crear película serie");
        }

    }

    @PutMapping(value = "/actualizarPeliculaSerie", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizarPeliculaSerie(@RequestBody PeliculaSerieDto peliculaSerieDto){

        try{
            return new ResponseEntity<>(this.peliculaSerieService.actualizarPeliculaSerie(peliculaSerieDto),HttpStatus.OK);
        }catch (IllegalStateException e){
            e.printStackTrace();
            return ResponseHandler.generarRespuesta(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseHandler.generarRespuesta(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Ha ocurrido un error al intentar actualizar película serie");
        }
    }

    @DeleteMapping(value = "/eliminarPeliculaSerie")
    public ResponseEntity<?> eliminarPeliculaSerie(@RequestParam("id") Long id){
        this.peliculaSerieService.eliminarPeliculaSerie(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "listarPeliculaSerie", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ListarPeliculaSerieDto>> listarPeliculaSerie(){
        return new ResponseEntity<>(this.peliculaSerieService.listarPeliculaSerie(), HttpStatus.OK);
    }

    @GetMapping(value = "listarPeliculaSeries", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ListarPeliculaSerieProjection>> listarPeliculaSeries(){
        return new ResponseEntity<>(this.peliculaSerieService.listarPeliculaSeries(), HttpStatus.OK);
    }

    @GetMapping(value = "detallePeliculaSerie", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DetallePeliculaSerieDto>> detallePeliculaSerie(){
        return new ResponseEntity<>(this.peliculaSerieService.detallePeliculaSerie(), HttpStatus.OK);
    }

    @GetMapping(value = "buscarPeliculaSeriePorNombre", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PeliculaSerieDto>> buscarPeliculaSeriePorNombre(@RequestParam("nombre") String nombre){
        return new ResponseEntity<>(this.peliculaSerieService.buscarPeliculaSeriePorNombre(nombre), HttpStatus.OK);
    }

    @GetMapping(value = "buscarPeliculaSeriePorIdGenero", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DetallePeliculaSerieDto>> buscarPeliculaSeriePorIdGenero(@RequestParam("id") Long id){
        return new ResponseEntity<>(this.peliculaSerieService.buscarPeliculaSeriePorIdGenero(id), HttpStatus.OK);
    }

    @GetMapping(value = "listarPeliculaSeriePorOrden", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PeliculaSerieDto>> listarPeliculaSeriePorOrden(@RequestParam("orden") String orden){
        return new ResponseEntity<>(this.peliculaSerieService.listarPeliculaSeriePorOrden(orden), HttpStatus.OK);
    }

}

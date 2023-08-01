package com.api.pelicula.model.projection;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDateTime;

@JsonPropertyOrder({"id", "imagen", "titulo", "fechaCreacion"})
public interface ListarPeliculaSerieProjection {

    Long getId();

    String getImagen();

    String getTitulo();

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    LocalDateTime getFechaCreacion();
}

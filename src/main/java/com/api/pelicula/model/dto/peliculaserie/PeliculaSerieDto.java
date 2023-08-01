package com.api.pelicula.model.dto.peliculaserie;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
public class PeliculaSerieDto {

    private Long id;

    private String imagen;

    private String titulo;

    private Integer calificacion;

    private Boolean eliminado;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime fechaCreacion;

}

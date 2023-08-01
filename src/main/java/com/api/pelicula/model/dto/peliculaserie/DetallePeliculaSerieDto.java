package com.api.pelicula.model.dto.peliculaserie;

import com.api.pelicula.model.dto.personaje.PersonajeDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
public class DetallePeliculaSerieDto {

    private Long id;

    private String imagen;

    private String titulo;

    private Integer calificacion;

    private Boolean eliminado;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime fechaCreacion;

    private List<PersonajeDto> listaPersonajeDto;
}

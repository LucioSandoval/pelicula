package com.api.pelicula.model.dto.genero;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class GeneroDto {

    private Long id;

    private String nombre;

    private String imagen;

    private Boolean eliminado;
}

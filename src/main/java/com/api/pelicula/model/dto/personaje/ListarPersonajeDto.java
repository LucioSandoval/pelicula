package com.api.pelicula.model.dto.personaje;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ListarPersonajeDto {

    private Long id;

    private String imagen;

    private String nombre;
}

package com.api.pelicula.model.dto.personaje;

import com.api.pelicula.common.validation.ValidationMessages;
import com.api.pelicula.model.dto.peliculaserie.PeliculaSerieDto;
import com.api.pelicula.model.entity.PeliculaSerieEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@Builder
public class ListarDetallePersonajeDto {

    private Long id;

    private String imagen;

    private String nombre;

    private  Integer edad ;

    private Double peso;

    private String historia;

    private Boolean eliminado;

    private List<PeliculaSerieDto> peliculasSeries;
}

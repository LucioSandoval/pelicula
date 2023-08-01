package com.api.pelicula.model.dto.personaje;

import com.api.pelicula.common.validation.ValidationMessages;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@Builder
public class PersonajeDto {

    private Long id;


    @NotBlank(message = ValidationMessages.SOLICITUD_VACIA_ERROR_MENSAJE)
    //@Size(max = 250, message = ValidationMessages.REQUEST_PARAM_SIZE_MAX_ERROR_MESSAGE)
    private String imagen;

    @NotBlank(message = ValidationMessages.SOLICITUD_VACIA_ERROR_MENSAJE)
    private String nombre;


    private  Integer edad ;

    private Double peso;

    private String historia;

    private Boolean eliminado;

}

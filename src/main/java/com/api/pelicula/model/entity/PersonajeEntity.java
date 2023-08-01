package com.api.pelicula.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "personaje")
@Getter
@Setter
public class PersonajeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "imagen", nullable = false)
    private String imagen;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "edad", nullable = false)
    private  Integer edad ;

    @Column(name = "peso", nullable = false, scale = 2)
    private Double peso;

    @Column(name = "historia", nullable = false)
    private String historia;

    @Column(name = "eliminado", nullable = false)
    private Boolean eliminado;

    @ManyToMany(mappedBy = "personajes", cascade = CascadeType.ALL)
    private List<PeliculaSerieEntity> peliculasSeries = new ArrayList<>();

    public void agregarPeliculaSerie(PeliculaSerieEntity peliculaSerieEntity){
        this.peliculasSeries.add(peliculaSerieEntity);
        peliculaSerieEntity.getPersonajes().add(this);
    }

}

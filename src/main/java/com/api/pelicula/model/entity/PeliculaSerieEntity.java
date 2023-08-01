package com.api.pelicula.model.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pelicula_serie")
@Data
public class PeliculaSerieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "imagen", nullable = false)
    private String imagen;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "fecha_creacion")
    @CreatedDate()
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    @Column(name = "calificacion", nullable = false)
    private Integer calificacion;

    @Column(name = "eliminado", nullable = false)
    private Boolean eliminado;

    @ManyToMany
    @JoinTable(name = "pelicula_serie_personaje",
            joinColumns = @JoinColumn(name = "pelicula_serie_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "personaje_id", referencedColumnName = "id"))
    private List<PersonajeEntity> personajes;

    @ManyToMany
    @JoinTable(name = "pelicula_serie_genero",
            joinColumns = @JoinColumn(name = "pelicula_serie_id"),
            inverseJoinColumns = @JoinColumn(name = "genero_id"))
    private List<GeneroEntity> generos;


}
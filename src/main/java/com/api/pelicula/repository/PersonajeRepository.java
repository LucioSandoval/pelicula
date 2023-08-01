package com.api.pelicula.repository;

import com.api.pelicula.model.entity.PersonajeEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PersonajeRepository extends JpaRepository<PersonajeEntity, Long> {
    <T> List<T> findByEliminadoFalse(Class<T> class1);

    @Query("SELECT DISTINCT p FROM PersonajeEntity p JOIN FETCH p.peliculasSeries ps WHERE p.eliminado = false AND ps.eliminado = false")
    List<PersonajeEntity> findBy();
    List<PersonajeEntity> findByEliminadoFalseAndNombre(String nombre);
    List<PersonajeEntity> findByEliminadoFalseAndEdad(Integer edad);

    List<PersonajeEntity> findByEliminadoFalseAndPeliculasSeriesEliminadoFalseAndPeliculasSeriesId(Long id);


}

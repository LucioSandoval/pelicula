package com.api.pelicula.repository;

import com.api.pelicula.model.entity.PeliculaSerieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PeliculaSerieRepository extends JpaRepository<PeliculaSerieEntity, Long> {

    <T> List<T> findByEliminadoFalse(Class<T> tClass);
    @Query("SELECT DISTINCT ps FROM PeliculaSerieEntity ps JOIN FETCH ps.personajes p WHERE ps.eliminado = false AND p.eliminado = false")
    List<PeliculaSerieEntity> detallePeliculaSerie();

    List<PeliculaSerieEntity> findByEliminadoFalseAndTitulo(String titulo);

    //@Query("SELECT FROM PeliculaSerieEntity ps WHERE ps.eliminado = false ORDER BY ps.fechaCreacion DESC")
    List<PeliculaSerieEntity> findByEliminadoFalseOrderByFechaCreacionDesc();
    
    List<PeliculaSerieEntity> findByEliminadoFalseOrderByFechaCreacionAsc();

    List<PeliculaSerieEntity> findByEliminadoFalseAndGenerosEliminadoFalseAndGenerosId(Long id);
}

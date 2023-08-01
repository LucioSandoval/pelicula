package com.api.pelicula.repository;

import com.api.pelicula.model.entity.GeneroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeneroRepository extends JpaRepository<GeneroEntity, Long> {

    List<GeneroEntity> findByEliminadoFalse();
}

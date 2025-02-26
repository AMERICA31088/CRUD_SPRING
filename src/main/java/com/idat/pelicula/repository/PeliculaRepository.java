package com.idat.pelicula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.pelicula.model.Pelicula;

@Repository
public interface PeliculaRepository extends JpaRepository <Pelicula, Long> {

}

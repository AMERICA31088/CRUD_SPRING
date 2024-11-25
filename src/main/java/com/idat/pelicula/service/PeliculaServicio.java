package com.idat.pelicula.service;

import java.util.List;

import com.idat.pelicula.model.Pelicula;

public interface PeliculaServicio {
	
public List<Pelicula> listarTodosLosPelicula();
	
	public Pelicula GuardarPelicula(Pelicula pelicula);
	
	public Pelicula obtenerPeliculaPorID(Long id);
	
	public Pelicula actualizarPelicula(Pelicula pelicula);
	
	public void eliminarPelicula(Long id);

}

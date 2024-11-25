package com.idat.pelicula.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pelicula.model.Pelicula;
import com.idat.pelicula.repository.PeliculaRepository;

@Service
public class PeliculaServicioImpl implements PeliculaServicio {

	@Autowired
	private PeliculaRepository repository;

	@Override
	public List<Pelicula> listarTodosLosPelicula() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Pelicula GuardarPelicula(Pelicula pelicula) {
		// TODO Auto-generated method stub
		return repository.save(pelicula);
	}

	@Override
	public Pelicula obtenerPeliculaPorID(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public Pelicula actualizarPelicula(Pelicula pelicula) {
		// TODO Auto-generated method stub
		return repository.save(pelicula);
	}

	@Override
	public void eliminarPelicula(Long id) {
		repository.deleteById(id);
		
	}

}

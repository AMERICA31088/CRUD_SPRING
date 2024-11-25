package com.idat.pelicula.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="pelicula")
public class Pelicula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "titulo", nullable = false,length = 30)
	private String titulo;
	
	
	@Column(name = "genero", nullable = false,length = 30)
	private String genero;
	
	@Column(name = "pais", nullable = false,length = 30)
	private String pais;
	
	@Column(name = "director", nullable = false,length = 30)
	private String director;
	

	
	@Column(name = "anio", nullable = false,length = 30)
	private String anio;
	
	public Pelicula () {
		
	}

	public Pelicula(long id, String titulo, String genero, String pais, String director, String anio) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.genero = genero;
		this.pais = pais;
		this.director = director;
		this.anio = anio;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}
	
	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", genero=" + genero
				+ ", pais=" + pais + ", director=" + director + ", anio=" + anio
				+ "]";
	}
	

}

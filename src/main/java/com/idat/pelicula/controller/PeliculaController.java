package com.idat.pelicula.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.idat.pelicula.model.Pelicula;
import com.idat.pelicula.service.PeliculaServicio;

@Controller
public class PeliculaController {

    @Autowired
    private PeliculaServicio servicio;

    
    @GetMapping({ "/pelicula", "/" })
    public String listarPelicula(Model modelo) {
        modelo.addAttribute("pelicula", servicio.listarTodosLosPelicula());
        return "pelicula"; // Nombre de la vista Thymeleaf
    }

    
    @GetMapping("/pelicula/buscar")
    public String buscarPelicula(@RequestParam("id") Long id, Model modelo) {
        
        Pelicula pelicula = servicio.obtenerPeliculaPorID(id);
        
        
        if (pelicula != null) {
            modelo.addAttribute("pelicula", List.of(pelicula)); 
        } else {
            modelo.addAttribute("pelicula", List.of()); 
            modelo.addAttribute("mensaje", "No se encontró la película con ID " + id);
        }
        return "pelicula"; 
    }

	
	@GetMapping("/pelicula/nuevo")
	public String MostrarFormularioDeRegistrarPelicula(Model modelo) {
		Pelicula empleado = new Pelicula();
		modelo.addAttribute("pelicula", empleado);
		return "crear_pelicula";

	}

	@PostMapping("/pelicula/guardar")
	public String guardarPelicula(@ModelAttribute("pelicula") Pelicula pelicula) {
		servicio.GuardarPelicula(pelicula);
		return "redirect:/pelicula";
	
}
	
	@GetMapping("/pelicula/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("pelicula", servicio.obtenerPeliculaPorID(id));
		return "editar_pelicula";
	}

	// Cambié la URL de este método para que no haya conflicto con el otro mapeo
	@PostMapping("/pelicula/editar/{id}")
	public String actualizarPelicula(@PathVariable Long id, @ModelAttribute("pelicula") Pelicula pelicula, Model modelo) {
		Pelicula peliculaExistente = servicio.obtenerPeliculaPorID(id);
		peliculaExistente.setId(id);
		peliculaExistente.setTitulo(pelicula.getTitulo());
		peliculaExistente.setGenero(pelicula.getGenero());
		peliculaExistente.setPais(pelicula.getPais());
		peliculaExistente.setDirector(pelicula.getDirector());
		peliculaExistente.setAnio(pelicula.getAnio());
		

		servicio.actualizarPelicula(peliculaExistente);

		return "redirect:/pelicula";
	}

	@GetMapping("/pelicula/eliminar/{id}")
	public String eliminarPelicula(@PathVariable Long id) {
		servicio.eliminarPelicula(id);
		return "redirect:/pelicula";
	}
	
}

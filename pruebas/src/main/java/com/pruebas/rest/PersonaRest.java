package com.pruebas.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebas.dao.PersonaDAO;
import com.pruebas.model.Persona;


@RestController
@RequestMapping("V1/personas")
public class PersonaRest{
	
	@Autowired
	private PersonaDAO personaDAO;
	
	// metodos HTTP 
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody Persona persona) {
		personaDAO.save(persona);
		System.out.println("Se agrego la personaen la base de datos");
	}
	
	@GetMapping("/listar")
	public List<Persona>  listarPersonas(){
		return personaDAO.findAll();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Integer id ) {
		personaDAO.deleteById(id);
		return "Fue elminado el ID: " + id;
	}
	
	
	
}

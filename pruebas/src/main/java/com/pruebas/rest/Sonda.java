package com.pruebas.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Sonda {
	
	@RequestMapping("V1/sonda")
	public String sonda() {
		//busca todas las ordenes pendiente para validar el cambio de estado 
		return "Se ha corrido la sonda";
	}

}

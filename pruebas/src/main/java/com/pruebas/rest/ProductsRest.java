package com.pruebas.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.pruebas.dao.ProductsDAO;
import com.pruebas.model.products;


@RestController
@RequestMapping("V1/products")
public class ProductsRest{
	
	@Autowired
	private ProductsDAO productsDAO;
	
	// metodos HTTP 
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody products products) {
		productsDAO.save(products);
		System.out.println("Se agrego el producto  en la base de datos");
	}
	
	@GetMapping("/listar")
	public List<products>  listarProducts(){
		return productsDAO.findAll();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Integer id ) {
		productsDAO.deleteById(id);
		return "Fue elminado el ID: " + id;
	}
	
	
	
}

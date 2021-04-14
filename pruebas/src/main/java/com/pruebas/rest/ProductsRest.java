package com.pruebas.rest;

import java.io.Console;
import java.util.List;
import java.util.Optional;

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
	
	@GetMapping("/buscar/{id}")
	public products buscar(@PathVariable("id") int id ) {
		products productoObj = new products();
		try {
			System.out.println("Estoy dentro del Try con ID : "+ id);
			productoObj = this.buscarPorID(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Mensage de Error: "+ e.getMessage());
		}
		return productoObj;
	}
	
	public products buscarPorID(int id) {
		products respuestaOBJ = new products();
		Optional<products> respuestaOBJ2 = productsDAO.findById(id);
		respuestaOBJ = respuestaOBJ2.get();
		return respuestaOBJ;
	}
	
	
}

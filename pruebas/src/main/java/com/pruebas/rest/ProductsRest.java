package com.pruebas.rest;

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

import com.pruebas.dao.CarDAO;
import com.pruebas.dao.ProductsDAO;
import com.pruebas.model.Car;
import com.pruebas.model.Products;


@RestController
@RequestMapping("V1/products")
public class ProductsRest{
	
	@Autowired
	private ProductsDAO productsDAO;
	
	private CarDAO carDAO;
	
	
	// metodos HTTP 
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody Products products) {
		productsDAO.save(products);
		System.out.println("Se agrego el producto  en la base de datos");
	}
	
	@GetMapping("/listar")
	public List<Products>  listarProducts(){
		return productsDAO.findAll();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Integer id ) {
		productsDAO.deleteById(id);
		return "Fue elminado el ID: " + id;
	}
	
	@GetMapping("/buscar/{id}")
	public Products buscar(@PathVariable("id") int id ) {
		Products productoObj = new Products();
		try {
			System.out.println("Estoy dentro del Try con ID : "+ id);
			productoObj = this.buscarPorID(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Mensage de Error: "+ e.getMessage());
		}
		return productoObj;
	}
	
	@GetMapping("/addCar")
	public void addCard() {
		Products producto = new Products();
		producto = buscarPorID(73);
		Car carrito = new Car();
		carrito.setCantidad(1); 
		carrito.setCustomer(43);
		carrito.setPrecio(200);
		carrito.setProducto(73);
		carDAO.save(carrito);
		
	}
	
	public Products buscarPorID(int id) {
		Products respuestaOBJ = new Products();
		Optional<Products> respuestaOBJ2 = productsDAO.findById(id);
		respuestaOBJ = respuestaOBJ2.get();
		return respuestaOBJ;
	}
	
	
}

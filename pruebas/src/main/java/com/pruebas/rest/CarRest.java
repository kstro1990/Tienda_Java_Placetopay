package com.pruebas.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.pruebas.rest.ProductsRest;


@RestController
@RequestMapping("V1/car")
public class CarRest {
	@Autowired
	private CarDAO carDao;
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody Car car) {
		carDao.save(car);
		System.out.println("se creo la orden: ");
	}
	
	@GetMapping("/add/{id}")
	public void addCar(@PathVariable("id") int id) {
		Car carrito = new Car(); 
		Products producto = new Products(); 
		ProductsRest buscar = new ProductsRest();
		try {
			carrito.setCantidad(1); 
			carrito.setCustomer(43);
			carrito.setPrecio(200);
			carrito.setProducto(73);
			carDao.save(carrito);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@GetMapping("/listar")
	public List<Car> listarOrdenes(){
		return carDao.findAll();
	}
}

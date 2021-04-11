package com.pruebas.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebas.dao.CarDAO;
import com.pruebas.model.Car;

@RestController
@RequestMapping("V1/car")
public class CarRest {
	@Autowired
	private CarDAO ordersDAO;
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody Car car) {
		ordersDAO.save(car);
		System.out.println("se creo la orden: ");
	}
	
	@GetMapping("/listar")
	public List<Car> listarOrdenes(){
		return ordersDAO.findAll();
	}
}

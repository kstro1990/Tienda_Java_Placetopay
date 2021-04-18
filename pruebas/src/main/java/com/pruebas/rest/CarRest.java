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
import com.pruebas.model.Car;
import com.pruebas.model.CarTemp;
import com.pruebas.model.Products;


@RestController
@RequestMapping("V1/car")
public class CarRest {
	@Autowired
	private CarDAO carDao;
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody Car car) {
		carDao.save(car);
	}
	
	@GetMapping("/listar")
	public List<Car> listarCar(){
		return carDao.findAll();
	}
	
	@GetMapping("/listarPorUsuario/{id}")
	public CarTemp agrupar(@PathVariable("id") int id) {
		List<Car> respuesta =  carDao.findByCustomer(id);
		float precioSuma  = 0;
		int cantidadSuma = respuesta.size();
		for (Car car : respuesta) {
			precioSuma = precioSuma + car.getPrecio();
		}
		CarTemp CarritoTemporal = new CarTemp();
		CarritoTemporal.setTotalAmout(precioSuma);
		CarritoTemporal.setTotalProduct(cantidadSuma);
		return CarritoTemporal;
	}
	
	@GetMapping("/join/{id}")
	public List<Car> join(@PathVariable("id") int id) {
		List<Car> respuesta = carDao.joinCarrito(id);
		return respuesta;
	}
	
}

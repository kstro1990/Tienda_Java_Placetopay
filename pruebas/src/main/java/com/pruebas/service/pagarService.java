package com.pruebas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebas.dao.CarDAO;
import com.pruebas.model.Car;
import com.pruebas.model.CarTemp;

@Service
public class pagarService {

	@Autowired
	private CarDAO carDao;
	
	public CarTemp agrupar(int id) {
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
}

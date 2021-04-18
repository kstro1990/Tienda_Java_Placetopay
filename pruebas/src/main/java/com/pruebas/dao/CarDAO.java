package com.pruebas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pruebas.model.Car;

public interface CarDAO extends JpaRepository<Car, Integer> {
	
	List<Car> findByCustomer(int customer);

	
	@Query
	(value = "select * from tienda_java.car car inner join persona p2 \r\n"
			+ "on car.customer = p2.id \r\n"
			+ "where car.customer = ?",nativeQuery = true)
	List<Car> joinCarrito(int valor);

}

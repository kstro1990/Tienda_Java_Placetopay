package com.pruebas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebas.model.Car;

public interface CarDAO extends JpaRepository<Car, Integer> {

}

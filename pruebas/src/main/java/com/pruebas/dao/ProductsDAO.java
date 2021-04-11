package com.pruebas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebas.model.products;

public interface ProductsDAO extends JpaRepository<products, Integer> {

}

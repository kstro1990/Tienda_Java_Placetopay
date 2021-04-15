package com.pruebas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebas.model.Products;

public interface ProductsDAO extends JpaRepository<Products, Integer> {

}

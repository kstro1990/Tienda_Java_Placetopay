package com.pruebas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebas.model.Orders;

public interface OrdersDAO extends JpaRepository<Orders, Integer> {

}

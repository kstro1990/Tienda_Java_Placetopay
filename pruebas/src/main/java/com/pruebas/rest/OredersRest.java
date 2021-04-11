package com.pruebas.rest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebas.dao.OrdersDAO;
import com.pruebas.model.Orders;

@RestController
@RequestMapping("V1/Orders")
public class OredersRest {
	@Autowired
	private OrdersDAO ordersDAO;
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody Orders orders) {
		ordersDAO.save(orders);
		Calendar fecha  = new GregorianCalendar();
		Integer hora = fecha.get(Calendar.HOUR_OF_DAY);
		String strDateFormat = "hh: mm: ss a dd-MMM-aaaa"; // El formato de fecha está especificado  
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
		System.out.println("se creo la orden: "+ fecha);
	}
	
	@GetMapping("/listar")
	public List<Orders> listarOrdenes(){
		return ordersDAO.findAll();
	}
}

package com.pruebas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaciones {
	
	@Column
	private String referencia; 
	private String status;
	private String cus;
	private float monto; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

}

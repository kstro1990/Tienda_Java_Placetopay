package com.pruebas.rest;

import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.placetopay.java_placetopay.PlaceToPay;
import com.placetopay.java_placetopay.Entities.Models.RedirectRequest;
import com.placetopay.java_placetopay.Entities.Models.RedirectResponse;
import com.pruebas.dao.PersonaDAO;
import com.pruebas.model.Amount;
import com.pruebas.model.CarTemp;
import com.pruebas.model.Payment;
import com.pruebas.model.Person;
import com.pruebas.model.Persona;
import com.pruebas.model.RedirectResponseTemp;
import com.pruebas.model.RequestP2P;

import com.pruebas.service.pagarService;

@RestController
@RequestMapping("V1/pagar")
public class Pargar {
	
	@Autowired
	private PersonaDAO personaDAO;

	@PostMapping("/p2p")
	public RedirectResponseTemp createRequest(@RequestBody CarTemp carTemp) {
		try {
			PlaceToPay p2p = new PlaceToPay(
					"1863f8a3ba0e8d4290137c4b18fa4286",
	                "97d3E70wO36CoQjS",
	                new URL("https://test.placetopay.ec/redirection/"));
			RequestP2P requestData = new RequestP2P();
			ObjectMapper mapper = new ObjectMapper();
			
			Persona buyerGet =  personaDAO.findById(carTemp.getCustomerID());
			
			Person buyer = new Person();
			buyer.setName(buyerGet.getNombre()); 
			buyer.setSurname(buyerGet.getApellido());
			buyer.setDocument("1234567890");
			buyer.setDocumentType("CI");
			buyer.setEmail(buyerGet.getEmail());
			buyer.setMobile(buyerGet.getMobile());
			
			
			
			Amount amount = new Amount();
			amount.setCurrency("USD");
			amount.setTotal(200);
			
			Payment payment = new Payment();
			payment.setReference("13213 R");
			payment.setAmount(amount);
			
			requestData.setPayment(payment);
			requestData.setBuyer(buyer);
			
			System.out.println(carTemp);
			
			String jsonString = mapper.writeValueAsString(requestData);
			RedirectRequest reqP2p = new RedirectRequest(jsonString);
			System.out.println(jsonString);
			RedirectResponse response = p2p.request(reqP2p);
			System.out.println(response.getProcessUrl());
			RedirectResponseTemp redResTPM = new RedirectResponseTemp();
			
			redResTPM.setProcessUrl(response.getProcessUrl());
			redResTPM.setRequestId(response.getRequestId());
			redResTPM.setStatus(response.getStatus().toString());
			
			return redResTPM;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			
		}
		return null;
	}
	
	
}

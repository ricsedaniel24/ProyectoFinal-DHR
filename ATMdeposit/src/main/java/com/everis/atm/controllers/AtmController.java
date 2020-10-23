package com.everis.atm.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.atm.model.ATM;
import com.everis.atm.services.IATMservice;




@RestController
@RequestMapping("/atm")
public class AtmController {

	@Autowired
	private IATMservice service;
	
	@PostMapping(value = "/deposits")
	public ResponseEntity<ATM> AtmDeposit(@RequestBody String document) {
	
		ATM response = new ATM();
		
		try {
			response = service.consultaSaldo(document);
		} catch (Exception e) {
			return new ResponseEntity<ATM>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<ATM>(response, HttpStatus.OK);

	}
	
	
}

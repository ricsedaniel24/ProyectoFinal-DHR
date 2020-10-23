package com.everis.reniec.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.everis.reniec.model.Reniec;
import com.everis.reniec.services.IReniecServices;

@RestController
@RequestMapping("/external/reniec")

public class ReniecController {

	@Autowired
    private IReniecServices service;

	@PostMapping(value = "/validate")
	public ResponseEntity<Reniec> validar(@RequestBody String document) {

		Reniec response = new Reniec();
		response = service.getValidate(document);
		 if ( response == null ) {
		        
	            return  ResponseEntity.notFound().build();
	        }
	        return  ResponseEntity.ok(response);

	}

	
}

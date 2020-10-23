package com.everis.fingerprints.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.fingerprints.model.FingerPrints;
import com.everis.fingerprints.services.IFingerPrintServices;


@RestController
@RequestMapping("/core/fingerprints")

public class FingerPrintController {

	@Autowired
    private IFingerPrintServices service;

	
	@PostMapping(value = "/validate")
	public ResponseEntity<FingerPrints> validar(@RequestBody String document) {
	FingerPrints response= new FingerPrints();
		
		response = service.getValidate(document);
        if ( response == null ) {
        
            return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(response);
		
	}

	
}

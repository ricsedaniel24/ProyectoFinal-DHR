package com.everis.fingerprints.services;

import org.springframework.stereotype.Service;

import com.everis.fingerprints.model.FingerPrints;


@Service
public class FingerPrintServicesImpl implements IFingerPrintServices{


	@Override
	public FingerPrints getValidate(String dni) {
		
		System.out.println("dni finger : " + dni); //json

		FingerPrints response = new FingerPrints();

		response= FingerPrints.builder().entityName("Core").sucess(true).build();
	 
		return response;
	}
	
	
	
}

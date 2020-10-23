package com.everis.atm.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import com.everis.atm.entity.FingerPrints;



@FeignClient(name = "fingerprint-service",  url="localhost:8003")
@RequestMapping("/core/fingerprints")
public interface FingerPrintClient {
	
	@PostMapping(value = "/validate")
	public ResponseEntity<FingerPrints> validar(@RequestBody String document) ;
}

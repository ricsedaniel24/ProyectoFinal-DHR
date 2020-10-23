package com.everis.atm.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.everis.atm.entity.Reniec;





@FeignClient(name = "reniec-service",  url="localhost:8004")
@RequestMapping("/external/reniec")
public interface ReniecClient {
	
	@PostMapping(value = "/validate")
	public ResponseEntity<Reniec> validar(@RequestBody String document);
}

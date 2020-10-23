package com.everis.atm.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.everis.atm.entity.Person;


@FeignClient(name = "persons-service",  url="localhost:8002")
@RequestMapping("/core")
public interface PersonClient {

	@GetMapping(value = "/persons/{documentNumber}")
    public ResponseEntity<Person> getByDocument(@PathVariable("documentNumber") String documentNumber);
	
	
}

package com.everis.persons.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.persons.model.Person;
import com.everis.persons.services.IPersonService;

@RestController
@RequestMapping("/core")
public class PersonController {

	@Autowired
	private IPersonService service;
	
	
	@GetMapping(value = "/persons/{documentNumber}")
	public ResponseEntity<Person> getByDocument(@PathVariable("documentNumber") String documentNumber) {
		Optional<Person> person = service.findByDni(documentNumber);
		if (person.isPresent()) {

			return ResponseEntity.ok(person.get());
		} else {
			 return  ResponseEntity.notFound().build();

		}

	}

}

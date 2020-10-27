package com.everis.persons.controller;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import com.everis.persons.controllers.PersonController;
import com.everis.persons.model.Person;
import com.everis.persons.services.IPersonService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonControllerTest {

	

	
	 @Mock
	 private IPersonService service;
	    
	 @InjectMocks
	 private PersonController controller;
	
	
	 @BeforeEach
	    void setUp() {
		 	Person mockPerson = new Person();
		 	mockPerson.setId(1);
	        mockPerson.setDocument("10000000");
	        mockPerson.setFingerprint(true);
	        mockPerson.setBlacklist(true);

	      //log.info("--- mockperson  {} -->",Optional.of(mockPerson));
	        Mockito.when(service.findByDni("10000000")).thenReturn(Optional.of(mockPerson));
	      
	    }
	
	  @Test
	  void ValidFingerPrintByDocumentTest() {
		  ResponseEntity<Person> respuestaServicio;
//		  Optional<Person> respuestaServicio ;
	      respuestaServicio = controller.getByDocument("10000000");
	      Assertions.assertEquals(true,respuestaServicio.getBody().isFingerprint());
	      log.info("metodo ValidFingerPrintByDocumentTest  {} -->",respuestaServicio);
	  }
	  
	
	  @Test
	    void getPersonWithDocumentNotFound() {
	        ResponseEntity<Person> respuestaServicio;
	        respuestaServicio = controller.getByDocument("10000009");
	        Assertions.assertNull(respuestaServicio.getBody());
	    }
	  
//	}

}

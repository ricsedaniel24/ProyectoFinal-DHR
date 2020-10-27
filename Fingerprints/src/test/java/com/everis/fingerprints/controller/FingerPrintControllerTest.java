package com.everis.fingerprints.controller;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


import com.everis.fingerprints.controllers.FingerPrintController;
import com.everis.fingerprints.model.FingerPrints;
import com.everis.fingerprints.services.IFingerPrintServices;



public class FingerPrintControllerTest {

	
	 @Mock
	 private IFingerPrintServices service;
	    
	 @InjectMocks
	 private FingerPrintController controller;
	
//	 FingerPrints mockFingerPrint = new FingerPrints();
	 @BeforeEach
	    void setUp() {
	 FingerPrints mockFingerPrint = new FingerPrints();
		 
		 mockFingerPrint.setEntityName("Core");
		 mockFingerPrint.isSucess();
		 Mockito.when(service.getValidate("10000000")).thenReturn(mockFingerPrint);
	      
	    }
	
	  @Test
	  void ValidFingerPrintTest() {
		  ResponseEntity<FingerPrints> respuestaServicio;
//		  Optional<Person> respuestaServicio ;
	      respuestaServicio = controller.validar("10000000");
	      Assertions.assertNull(respuestaServicio.getBody());
	    
	  }
	  
	
//	  @Test
//	    void getPersonWithDocumentNotFound() {
//	        ResponseEntity<Person> respuestaServicio;
//	        respuestaServicio = controller.getByDocument("10000009");
//	        Assertions.assertNull(respuestaServicio.getBody());
//	    }
//	  
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Autowired
//    private IFingerPrintServices service;
//
//	
//	@PostMapping(value = "/validate")
//	public ResponseEntity<FingerPrints> validar(@RequestBody String document) {
//	FingerPrints response= new FingerPrints();
//		
//		response = service.getValidate(document);
//        if ( response == null ) {
//        
//            return  ResponseEntity.notFound().build();
//        }
//        return  ResponseEntity.ok(response);
//		
//	}

	
}

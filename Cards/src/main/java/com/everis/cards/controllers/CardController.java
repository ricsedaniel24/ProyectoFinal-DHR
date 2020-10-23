package com.everis.cards.controllers;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.everis.cards.model.Card;
import com.everis.cards.services.ICardService;



@RestController
@RequestMapping("/core")
public class CardController {
	
		@Autowired
		private ICardService service;
	
		@GetMapping(value = "/cards/{documentNumber}")
	    public ResponseEntity<List<Card>> getCardsNumber(@PathVariable("documentNumber") String documentNumber) {
		 List<Card> lista =null;
		 try {
			 lista = service.listaTarjetas(documentNumber);
			} catch (Exception e) {
				return new ResponseEntity<List<Card>>(lista, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity<List<Card>>(lista, HttpStatus.OK);

	    
		}

	
	
	
}

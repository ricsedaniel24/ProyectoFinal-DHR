package com.everis.atm.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.everis.atm.entity.Card;


@FeignClient(name = "cards-service",  url="localhost:8005")
@RequestMapping("/core")
public interface CardsClient {

	@GetMapping(value = "/cards/{documentNumber}")
    public ResponseEntity<List<Card>> getCardsNumber(@PathVariable("documentNumber") String documentNumber);
	
}

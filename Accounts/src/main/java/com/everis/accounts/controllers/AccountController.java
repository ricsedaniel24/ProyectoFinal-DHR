package com.everis.accounts.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.everis.accounts.model.AccountResponse;
import com.everis.accounts.services.IAccountService;


@RestController
@RequestMapping("/core")
public class AccountController {
	
		@Autowired
		private IAccountService service;

	
		@GetMapping(value = "/accounts/{cardNumber}")
	    public AccountResponse getAccounts(@PathVariable("cardNumber") String cardNumber) {
			return service.getAccounts(cardNumber);

		}
	
	
	
	
}

package com.everis.atm.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.everis.atm.entity.AccountResponse;

@FeignClient(name = "accounts-service",  url="localhost:8006")
@RequestMapping("/core")
public interface AccountsClient {
	@GetMapping(value = "/accounts/{cardNumber}")
    public AccountResponse getAccounts(@PathVariable("cardNumber") String cardNumber);
}

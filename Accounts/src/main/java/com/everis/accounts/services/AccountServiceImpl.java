package com.everis.accounts.services;


import org.springframework.stereotype.Service;

import com.everis.accounts.model.AccountResponse;




@Service
public class AccountServiceImpl implements IAccountService{


	
	@Override
	public AccountResponse getAccounts(String cardNumber) {
		
//		double montoAleatorio = Math.random()*5000 + 10;
		
		// Pausa
	    try {
	      Thread.sleep(5000);
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    }
		AccountResponse	account = AccountResponse.builder().accountNumber(cardNumber+"XXX").amount(100).build();
		
		return account;
	}

}

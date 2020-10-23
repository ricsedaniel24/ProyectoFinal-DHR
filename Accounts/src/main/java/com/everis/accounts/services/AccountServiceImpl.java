package com.everis.accounts.services;


import org.springframework.stereotype.Service;

import com.everis.accounts.model.Account;


@Service
public class AccountServiceImpl implements IAccountService{


	
	@Override
	public Account getAccounts(String cardNumber) {
		
		double montoAleatorio = Math.random()*5000 + 10;
		Account	account = Account.builder().accountNumber(cardNumber+"XXX").amount(montoAleatorio).build();
		
		return account;
	}

}

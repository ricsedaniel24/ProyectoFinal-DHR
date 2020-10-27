package com.everis.accounts.services;


import com.everis.accounts.model.AccountResponse;



public interface IAccountService {

//	public List<Account> getAccounts(String cardNumber);
	public AccountResponse getAccounts(String cardNumber);

	
}

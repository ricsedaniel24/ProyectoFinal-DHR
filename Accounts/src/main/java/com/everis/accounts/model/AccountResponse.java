package com.everis.accounts.model;


import lombok.Builder;
import lombok.Data;



@Data
@Builder
public class AccountResponse {

	private String accountNumber;

	private double amount;


	
	
	
}

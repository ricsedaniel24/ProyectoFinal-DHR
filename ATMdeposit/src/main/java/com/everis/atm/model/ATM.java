package com.everis.atm.model;

import java.util.List;

import com.everis.atm.entity.Accounts;


import lombok.Data;



@Data
public class ATM {
	
	private String  fingerprintEntityName;
	private List<Accounts>  validAccounts;
	private double  customerAmount;
	
}

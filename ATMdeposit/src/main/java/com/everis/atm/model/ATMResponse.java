package com.everis.atm.model;

import java.util.List;


import com.everis.atm.entity.AccountResponseAtm;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ATMResponse {
	
	private String  fingerprintEntityName;
	private List<AccountResponseAtm>  validAccounts;
	private double  customerAmount;
	
	  public void addAmount(double ammount) {
		     this.customerAmount = this.customerAmount +ammount;
		  }
	
}

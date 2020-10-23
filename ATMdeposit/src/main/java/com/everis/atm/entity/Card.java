package com.everis.atm.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Card {

	private String cardNumber;

	private boolean active;
	
	
	
}

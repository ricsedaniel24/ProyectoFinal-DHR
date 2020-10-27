package com.everis.atm.entity;



import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Card {

	private String cardNumber;

	private boolean active;

	
	
}

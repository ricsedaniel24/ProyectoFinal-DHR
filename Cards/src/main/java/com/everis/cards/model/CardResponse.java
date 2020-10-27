package com.everis.cards.model;

import java.util.List;

import com.everis.cards.entity.Card;

import lombok.Getter;

import lombok.Setter;


@Getter
@Setter
public class CardResponse {

//	private String cardNumber;
//
//	private boolean active;
	
	private List<Card> cards;
	
}

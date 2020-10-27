package com.everis.cards.services;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Service;

import com.everis.cards.entity.Card;
import com.everis.cards.model.CardResponse;

@Service
public class CardServiceImpl implements ICardService{



	@Override
	public CardResponse listaTarjetas(String dni) {
		
		List<Card>  dataRepository = new ArrayList<>();
		dataRepository.add(new Card("1111222233334441", true));
		dataRepository.add(new Card("1111222233334442", true));
		dataRepository.add(new Card("1111222233334443", true));
		dataRepository.add(new Card("1111222233334444", false));
		dataRepository.add(new Card("1111222233334445", false));
		dataRepository.add(new Card("1111222233334446", false));
	    CardResponse cardResponse = new CardResponse();
	    cardResponse.setCards(dataRepository);
		
		return cardResponse;

	}

}

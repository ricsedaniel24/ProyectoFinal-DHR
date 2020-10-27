package com.everis.atm.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.everis.atm.clients.AccountsClient;
import com.everis.atm.clients.CardsClient;
import com.everis.atm.clients.FingerPrintClient;
import com.everis.atm.clients.PersonClient;
import com.everis.atm.clients.ReniecClient;
import com.everis.atm.entity.AccountResponse;
import com.everis.atm.entity.AccountResponseAtm;
import com.everis.atm.entity.Card;
import com.everis.atm.entity.CardResponse;
import com.everis.atm.entity.FingerPrints;
import com.everis.atm.entity.Person;
import com.everis.atm.entity.Reniec;
import com.everis.atm.model.ATMRequest;
import com.everis.atm.model.ATMResponse;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service

public class ATMserviceImpl implements IATMservice{

	@Autowired
    PersonClient personClient; 
    @Autowired
    FingerPrintClient fingerClient;
    @Autowired
    ReniecClient reniecClient;
    @Autowired
    CardsClient cardClient;
    @Autowired
    AccountsClient accountClient;
    
    double montoTotal = 0;
    AccountResponse account = new AccountResponse();
    long start = System.currentTimeMillis();
    
    AccountResponseAtm accountResponseAtm;
    
	@Override
//	public ATMResponse consultaSaldo(String document) {
    	public ATMResponse consultaSaldo(ATMRequest atmrequest) {

		Person person = new Person();
		FingerPrints fingerPrint = new FingerPrints();
		Reniec reniec = new Reniec();
		ATMResponse atmResponse = null;

		List<Card> cardList = new ArrayList<>();
		List<AccountResponse> cuentasValidas = new ArrayList<>();

		// capturando el JSON document 
//		JSONObject jsonDocument = new JSONObject(document);
//		String documentNumber = jsonDocument.getString("document");

		
		// llamada al servicio PERSON
//		person = personClient.getByDocument(documentNumber).getBody();
		person = personClient.getByDocument(atmrequest.getDocument()).getBody();
		
		if (person.isFingerprint() == false) {
			// llamada a la API Reniec
			reniec = reniecClient.validar(atmrequest.getDocument()).getBody();
			atmResponse.setFingerprintEntityName(reniec.getEntityName());

		} else {

			// llamada a la API FingerPrint
			fingerPrint = fingerClient.validar(atmrequest.getDocument()).getBody();
			atmResponse.setFingerprintEntityName(fingerPrint.getEntityName());
		}

		// llamada a la API Cards
		CardResponse cardResponse = findCardClient(atmrequest.getDocument());
		List<Card> listCards = cardResponse.getCards();

		List<Card> cardsActive = listCards.stream().filter(card -> card.isActive()).collect(Collectors.toList());

		List<AccountResponse> listAccountResponse = new ArrayList<>();

		List<AccountResponseAtm> listAccountResponseAtm = new ArrayList<>();

		cardsActive.parallelStream().forEach(card -> {
			AccountResponse accountResponse = getAccountClient(card.getCardNumber());
			listAccountResponse.add(accountResponse);
			accountResponseAtm = new AccountResponseAtm();
			accountResponseAtm.setAccountNumber(accountResponse.getAccountNumber());
			listAccountResponseAtm.add(accountResponseAtm);
			
			
			atmResponse.setValidAccounts(listAccountResponseAtm);
			atmResponse.addAmount(accountResponse.getAmount());
		});

		return atmResponse;

		
		
	}
	

	
	public CardResponse findCardClient(String document) {
		return  cardClient.getCardsNumber(document);
	}
	public AccountResponse getAccountClient(String cardNumber) {
		return accountClient.getAccounts(cardNumber);
	}
	
	
	
	
	

	
	
}

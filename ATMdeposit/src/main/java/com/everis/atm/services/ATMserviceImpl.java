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
import com.everis.atm.entity.Accounts;
import com.everis.atm.entity.Card;
import com.everis.atm.entity.FingerPrints;
import com.everis.atm.entity.Person;
import com.everis.atm.entity.Reniec;
import com.everis.atm.model.ATM;


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
    Accounts account = new Accounts();
    long start = System.currentTimeMillis();
    
	@Override
	public ATM consultaSaldo(String document) {


		Person person = new Person();
		FingerPrints fingerPrint = new FingerPrints();
		Reniec reniec = new Reniec();
		ATM atmResponse = new ATM();

		List<Card> cardList = new ArrayList<>();
		List<Accounts> cuentasValidas = new ArrayList<>();

		// capturando el JSON document 
		JSONObject jsonDocument = new JSONObject(document);

		String documentNumber = jsonDocument.getString("document");// capturando el valor del document

		log.info("dni : {}", documentNumber);
		// llamada al servicio PERSON
		person = personClient.getByDocument(documentNumber).getBody();

		if (person.isFingerprint() == false) {
			// llamada a la API Reniec
			reniec = reniecClient.validar(document).getBody();
			atmResponse.setFingerprintEntityName(reniec.getEntityName());

		} else {

			// llamada a la API FingerPrint
			fingerPrint = fingerClient.validar(document).getBody();
			atmResponse.setFingerprintEntityName(fingerPrint.getEntityName());
		}

		// llamada a la API Cards
		cardList = cardClient.getCardsNumber(documentNumber).getBody();

		cardList = cardList.stream().filter(data -> data.isActive() == true).collect(Collectors.toList());// lista de  tarjetas activas
		System.out.println("tarjetas activas -> " + cardList);

		
		// llamada a la API Accounts

		cardList.parallelStream().forEach((Card card) -> {
		    try { 
		    	
		    		account = accountClient.getAccounts(card.getCardNumber()).getBody();
		    		montoTotal = account.getAmount() + montoTotal;
					cuentasValidas.add(account);
					Thread.sleep(5000);
		    } catch (Exception ignore) {  }
		    System.out.print( " tiempos ->  ");
		    System.out.print((System.currentTimeMillis() - start) + " ");
		});
		
		//secuencial sin paralelismo
//		for (Card card : cardList) {
//		try {
//			Thread.sleep(5000);
//			account = accountClient.getAccounts(card.getCardNumber()).getBody();
//
//			montoTotal = account.getAmount() + montoTotal;
//			cuentasValidas.add(account);
//		} catch (Exception e) {
//
//		}

//		// llamada a la API Accounts
//		account = accountClient.getAccounts(card.getCardNumber()).getBody();
//
//		montoTotal = account.getAmount() + montoTotal;
//		cuentasValidas.add(account);
		
		
		
		atmResponse.setValidAccounts(cuentasValidas);
		atmResponse.setCustomerAmount(montoTotal);

		return atmResponse;

	}
	
	

	
	
}

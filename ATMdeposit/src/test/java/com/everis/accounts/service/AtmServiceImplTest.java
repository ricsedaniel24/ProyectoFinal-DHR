package com.everis.accounts.service;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;




import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

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
import com.everis.atm.services.ATMserviceImpl;


@ExtendWith(MockitoExtension.class)


public class AtmServiceImplTest {

	
	@Mock
    private PersonClient personclient;
	@Mock
    private CardsClient cardsclient;
	@Mock
    private FingerPrintClient fingerprintclient;
	@Mock
    private ReniecClient reniecclient;
	@Mock
    private AccountsClient accountclient;
	
	
	
	@InjectMocks
	ATMserviceImpl atmservice;
	
	 
	 @Test
		void getPersonByDocument() {

		 String document = "10000000";

			 Person mockPerson = new Person();
			 	mockPerson.setId(1);
		        mockPerson.setDocument("10000000");
		        mockPerson.setFingerprint(true);
		        mockPerson.setBlacklist(true);

		        Mockito.when(personclient.getByDocument(document)).thenReturn(ResponseEntity.of(Optional.of(mockPerson)));

			Person person = personclient.getByDocument(document).getBody();
		        assertThat(person).isEqualTo(mockPerson);
//			Assertions.assertEquals(true, mockPerson.isFingerprint());

		}
	 
	 @Test
		void getPersonReniecClient() {

		 	String document = "10000000";

			 Reniec mockReniec = new Reniec();
			 mockReniec.setEntityName("Reniec");
			 mockReniec.setSucess(true);
		     
			 Mockito.when(reniecclient.validar(document)).thenReturn(ResponseEntity.of(Optional.of(mockReniec)));
	
			 Reniec reniec = reniecclient.validar(document).getBody();
     		assertThat(reniec).isEqualTo(mockReniec);
	 }
	 @Test
		void getPersonFingerPrintClient() {

		 String document = "10000000";
		 //
		 		 	FingerPrints mockFingerPrint = new FingerPrints();
		 		 	mockFingerPrint.setEntityName("Core");
		 		 	mockFingerPrint.setSucess(true);
		     
		
			 Mockito.when(fingerprintclient.validar(document)).thenReturn(ResponseEntity.of(Optional.of(mockFingerPrint)));
			 FingerPrints fingerprint = fingerprintclient.validar(document).getBody();
//			 Assertions.assertEquals(fingerprint, mockFingerPrint);
  		assertThat(fingerprint).isEqualTo(mockFingerPrint);
	 }
	 

	 @Test
		void getCardsClient() {

		 List<Card>  dataRepository = new ArrayList<>();
		dataRepository.add(Card.builder().cardNumber("1111222233334442").active(true).build());
			
		
		

			CardResponse cardResponse = CardResponse.builder().cards(dataRepository).build();

			when(cardsclient.getCardsNumber("10000000")).thenReturn(cardResponse);

			CardResponse card = atmservice.findCardClient("10000000");

			assertThat(card).isEqualTo(cardResponse);

		}
	 
		@Test
		void getCardsClientReniec() {

			List<Card> cards = new ArrayList<>();
			cards.add(Card.builder().cardNumber("1111222233334441").active(true).build());
		

			CardResponse cardResponse = CardResponse.builder().cards(cards).build();

			when(cardsclient.getCardsNumber("10000000")).thenReturn(cardResponse);

			CardResponse card = atmservice.findCardClient("10000000");

			assertThat(card).isEqualTo(cardResponse);

		}
	 
		@Test
		void getAccountsClient() {

			AccountResponse mockAccount = new AccountResponse();
			 mockAccount.setAccountNumber("1111222233334441XXX");
			 mockAccount.setAmount(100);

			when(accountclient.getAccounts("1111222233334441")).thenReturn(mockAccount);

			AccountResponse account = atmservice.getAccountClient("1111222233334441");

			assertThat(account).isEqualTo(mockAccount);

		}
	 
		
		@Test
		void whenFindByDocument_ThenReturnAtmDepositResponseFingerPrint() {
			getPersonByDocument();
			getPersonReniecClient();
			getPersonFingerPrintClient();
			getCardsClient();
			getAccountsClient();

			ATMRequest atmRequest = ATMRequest.builder().document("10000000").build();


			List<AccountResponseAtm> validAccounts = new ArrayList<>();
			
			validAccounts.add(AccountResponseAtm.builder().accountNumber("1111222233334441XXX").build());

			ATMResponse atmResponse = ATMResponse.builder().fingerprintEntityName("Core")
					.validAccounts(validAccounts).customerAmount(100.00).build();
			
			ATMResponse atm = atmservice.consultaSaldo(atmRequest);
			
			assertThat(atm).isEqualTo(atmResponse);

		}
		
		
		
	
	
	 
	 	 
	 	//listado de tarjetas
	 	 private List<AccountResponse> getAccountsValid() {
	 		List<AccountResponse>  validsAccount = new ArrayList<>();
	 		validsAccount.add(new AccountResponse("1111222233334441XXX", 100));
	 		validsAccount.add(new AccountResponse("1111222233334442XXX", 100));
	 		validsAccount.add(new AccountResponse("1111222233334443XXX", 100));
			
			return validsAccount;
	 	  }
	 	
}

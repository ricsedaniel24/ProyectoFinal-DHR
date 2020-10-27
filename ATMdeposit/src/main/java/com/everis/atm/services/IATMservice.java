
package com.everis.atm.services;

import com.everis.atm.model.ATMRequest;
import com.everis.atm.model.ATMResponse;

public interface IATMservice {
	
	public ATMResponse consultaSaldo(ATMRequest atmrequest);

}

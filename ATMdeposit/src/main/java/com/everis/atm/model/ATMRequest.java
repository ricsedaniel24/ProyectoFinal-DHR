package com.everis.atm.model;

import java.util.List;

import com.everis.atm.entity.AccountResponse;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ATMRequest {
	private String  document;

}

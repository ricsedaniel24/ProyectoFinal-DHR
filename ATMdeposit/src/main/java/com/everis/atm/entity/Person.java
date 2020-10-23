package com.everis.atm.entity;


import lombok.Data;

@Data
public class Person  {
	
	private int id;

	private String document;

	private boolean fingerprint;
	
	private boolean blacklist;
	
}

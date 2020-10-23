package com.everis.persons.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="persons")
@Data
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "document")
	private String document;
	@Column(name = "fingerprint")
	private boolean fingerprint;
	@Column(name = "blacklist")
	private boolean blacklist;
	
	
}

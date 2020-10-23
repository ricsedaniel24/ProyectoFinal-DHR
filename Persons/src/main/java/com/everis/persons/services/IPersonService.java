package com.everis.persons.services;

import java.util.List;
import java.util.Optional;

import com.everis.persons.model.Person;

public interface IPersonService {
	
	public Person save(Person person);
	public Person update(Person person);
	public void delete(Integer id );
	public Optional<Person> findByDni(String dni);
	public List<Person> findAll();
	
	
}

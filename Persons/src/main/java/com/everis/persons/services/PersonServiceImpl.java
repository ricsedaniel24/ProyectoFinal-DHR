package com.everis.persons.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.everis.persons.dao.IPersonDAO;
import com.everis.persons.model.Person;


@Service
public class PersonServiceImpl implements IPersonService {
	
		@Autowired
	    private IPersonDAO dao;

		@Override
		public Person save(Person person) {
			return dao.save(person);
		}

		@Override
		public Person update(Person person) {
			return dao.save(person);
		}

		@Override
		public void delete(Integer id ) {
			dao.deleteById(id);
		}

		@Override
		public Optional<Person> findByDni(String document) {
			
			List<Person> persons=this.findAll();
			return persons.stream().filter(p -> p.getDocument().equalsIgnoreCase(document)).findFirst();		
		}

		@Override
		public List<Person> findAll() {
		
			return dao.findAll();
		}

		

		
		
		
}

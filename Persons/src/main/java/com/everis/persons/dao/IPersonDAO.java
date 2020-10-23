package com.everis.persons.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.persons.model.Person;



public interface IPersonDAO extends JpaRepository<Person, Integer> {

}

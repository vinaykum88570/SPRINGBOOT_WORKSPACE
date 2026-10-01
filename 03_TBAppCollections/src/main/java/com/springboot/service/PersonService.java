package com.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.Dao.PersonDao;
import com.springboot.model.Person;

@Service
public class PersonService {
	
	@Autowired
	private PersonDao personService;
	
	
	// Save Multiple Person
	public Iterable<Person> saveAllParsons(Iterable<Person> personList){
		return personService.saveAll(personList);
	}
	
	// Retrive Multiple Person
	public Iterable<Person>getMultipleParsons(Iterable<Integer> personIDs){
		return personService.findAllById(personIDs);
	}
}

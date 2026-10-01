package com.springboot.service;

import java.util.Date;
import java.util.List;

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
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	
	// select * from tbl_person where last_name=lastName or first_name=firstName;
	public Iterable<Person> findByLastNameOrFirstName(String lastName,String firstName){
		return personService.findByLastNameOrFirstName(lastName, firstName);
	}
	
	// select * from tbl_person where last_name=lastName and first_name=firstName;
	public Person findByLastNameAndFirstName(String lastName,String firstName ) {
		return personService.findByLastNameAndFirstName(lastName, firstName);
	}
	
	// select * from tbl_person where last_name=lastName order by created_date desc;
	public List<Person> findByLastNameOrderByCreatedDateDesc(String lastname){
		return personService.findByLastNameOrderByCreatedDateDesc(lastname);
	}

	// select * from tbl_person where age<=age;
	public List<Person> findByAgeLessThanEqual(Integer age){
		return personService.findByAgeLessThanEqual(age);
	}
	
	// select * from tbl_person where first_name='%firstName%';
	public List<Person> findByFirstNameLike(String firstName){
		return personService.findByFirstNameLike(firstName);
	}
	
	// select * from tbl_person where last_name=lastName and age<=age;
	public List<Person> findByLastNameAndAgeLessThanEqual(String lastname, int age){
		return personService.findByLastNameAndAgeLessThanEqual(lastname, age);
	}
	
	// select * from tbl_person where created_date>=startdate and created_date<=endDate;
	public List<Person> findByCreatedDateBetween(Date startDate,Date endDate){
		return personService.findByCreatedDateBetween(startDate, endDate);
	}
	
	
	
	
}

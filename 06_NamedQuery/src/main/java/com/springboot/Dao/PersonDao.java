package com.springboot.Dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.CustomType;
import com.springboot.model.Person;

@Repository
public interface PersonDao extends CrudRepository<Person, Integer> {

	
	public Iterable<Person> findByLastNameOrFirstName(String lastName,String firstName);
	// select * from tbl_person where last_name=lastName or first_name=firstName;
	
	public Person findByLastNameAndFirstName(String lastName,String firstName );
	// select * from tbl_person where last_name=lastName and first_name=firstName;
	
	public List<Person> findByLastNameOrderByCreatedDateDesc(String lastname);
	// select * from tbl_person where last_name=lastName order by created_date desc;
	
	public List<Person> findByAgeLessThanEqual(Integer age);
	// select * from tbl_person where age<=age;
	
	public List<Person> findByFirstNameLike(String firstName);
	// select * from tbl_person where first_name='%firstName%';
	
	public List<Person> findByLastNameAndAgeLessThanEqual(String lastname, int age);
	// select * from tbl_person where last_name=lastName and age<=age;
	
	public List<Person> findByCreatedDateBetween(Date startDate , Date endDate);
	// select * from tbl_person where created_date>=startdate and created_date<=endDate;
	
	
	/*
	 *     Named Query Section
	 *     Abstract Methods in The interface layer ==> Any name , no framework rules
	 *     implementation at Model/Domain/Entity layer
	 * 
	 * */
	
	public List<Person> giveDataByLastName(String lastName);// Abstract methods 
	
	// CustomType
	public List<CustomType> giveFewColumns(String lastName);// Abstract methods 
	
	
	
}
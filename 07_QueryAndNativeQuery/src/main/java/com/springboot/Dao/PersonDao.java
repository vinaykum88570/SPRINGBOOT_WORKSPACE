package com.springboot.Dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
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
	
	
	
	/*
	 *    Query And Nativ query Section
	 *    Query ==> Abstract Methods and Implementation both at interface layer itself 
	 *    
	 *    Query --> Only Java Class Names and Properties Names
	 *    
	 *    Native Query --> We Will Write database  tables and database columns
	 * */
	
	//Query --> We are going to write JPQL --> Writing Java Classes and Java Properties
	@Query("SELECT p FROM Person p WHERE p.firstName = ?1 OR p.email = ?2") // Implementation
	List<Person> findPersonInfoFirstNameOrEmail(String firstName,String email); // Abstract Method
	
	// Native Query  --> We are Going to Write SQL --> Writing Databse Tables Databse Columns 
	@Query(value="Select * from tbl_person p where p.first_Name=?1", nativeQuery = true)
	List<Person> findPersonInfoByFirstName(String firstName);
}
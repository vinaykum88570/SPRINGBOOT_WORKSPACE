package com.springboot.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.Dao.BookDao;
import com.springboot.Dao.EmployeeDao;
import com.springboot.Dao.PersonDao;
import com.springboot.model.Book;
import com.springboot.model.CustomType;
import com.springboot.model.Employee;
import com.springboot.model.Person;

@Service
public class PersonService {
	
	@Autowired
	private PersonDao personService;
	
	@Autowired
	private BookDao bookService;
	
	@Autowired
	private EmployeeDao empDao;
	
	public Iterable<Employee> saveAllEmployee(Iterable<Employee> emplist){
		return empDao.saveAll(emplist);
	}

	public Iterable<Employee> retriveAllEmployee(){
		return empDao.findAll();	
	}	
	
	public Iterable<Book> retriveByBookName(String bookName){
		return bookService.retriveByBookName(bookName);
	}
	
	public List<Object[]> getMaxSalaryByDept(List<String> deptNames){
		return empDao.getMaxSalaryByDept(deptNames);
	}
	
	
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
	
	
	public List<Person> giveDataByLastName(String lastName){
		return personService.giveDataByLastName(lastName);
	}
	
	// CustomeType
	public List<CustomType> giveFewColumns(String lastName){
		return personService.giveFewColumns(lastName);
	}
	
	// Query 
	public List<Person> findPersonInfoFirstNameOrEmail(String firstName,String email){
		return personService.findPersonInfoFirstNameOrEmail(firstName, email);
	}
	
	// Native Query
	public List<Person> findPersonInfoByFirstName(String firstName){
		return personService.findPersonInfoByFirstName(firstName);
	}
	
	// Pegination 
	public List<Person> findByLastName(String lastName, PageRequest peginationObj){
		return personService.findByLastName(lastName, peginationObj);
	}
}

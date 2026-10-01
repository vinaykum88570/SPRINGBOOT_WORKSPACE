package com.springboot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.model.Person;
import com.springboot.service.PersonService;

@SpringBootApplication
public class TbAppCollections1Application implements CommandLineRunner {

	@Autowired
	PersonService personService;
	
	public static void main(String[] args) {
		SpringApplication.run(TbAppCollections1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		createPerson();
//		getPersonBYId();
		
	}
	
	private void createPerson() {
		
			List<Person> personList = Arrays.asList(
					new Person("vinay", "vinay", "vinay@gmai.com", 30),
					new Person("ram", "ram", "ram@gmai.com", 30),
					new Person("raghu", "vinay", "raghuy@gmai.com", 23),
					new Person("sam", "sam", "sam@gmai.com", 30),
					new Person("tom", "vinay", "tom@gmai.com", 27),
					new Person("bob", "bob", "bob@gmai.com", 29),
					new Person("rob", "vinay", "rob@gmai.com", 22),
					new Person("som", "som", "som@gmai.com", 28),
					new Person("vinay", "vinay", "pinay@gmai.com", 24),
					new Person("vinay", "vinay", "linay@gmai.com", 32),
					new Person("vinay", "vinay", "minay@gmai.com", 43),
					new Person("vinay", "vinay", "minay@gmai.com", 60)
					);
			
			Iterable<Person> list = personService.saveAllParsons(personList);
			for (Person person : list) {
				System.out.println("Person Object :"+ person.toString() );
			}
	}
	
	private void getPersonBYId() {
		List<Integer> personList = new ArrayList<Integer>();
		personList.add(1);
		personList.add(3);
		personList.add(4);
		personList.add(5);
		personList.add(7);
		personList.add(8);
		personList.add(9);
		
		// findPerson
		Iterable<Person> personsList = personService.getMultipleParsons(personList);
		for (Person person : personsList) {
			System.out.println("Person Object :"+ person.toString() );
		}
	}

}

 package com.springboot;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.model.Book;
import com.springboot.model.CustomType;
import com.springboot.model.Employee;
import com.springboot.model.Person;
import com.springboot.service.PersonService;

@SpringBootApplication
public class SpringDataJpaAdvanceApplication implements CommandLineRunner {

	@Autowired
	private PersonService personService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaAdvanceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		createPerson();
		
//		findByLastNameOrFirstName();
//		findByLastNameAndFirstName();
//		findByLastNameOrderByCreatedDateDesc();
//		findByAgeLessThanEqual();
//		findByFirstNameLike();
//		findByLastNameAndAgeLessThanEqual();
//		findByCreatedDateBetween();
//		giveDataByLast();
//		retriveByBookName();
//		createEmpoyee();
//		getMaxSalByDept();
		giveFewColumns();
		
	}
	
	// Custom Type
	public void giveFewColumns() {
		List<CustomType> personList = personService.giveFewColumns("minay");
		for (CustomType type : personList) {
			System.out.println("Person Object :"+ type.toString() );
		}
	}
	
	private void getMaxSalByDept() {
		List<Object[]> list = personService.getMaxSalaryByDept(Arrays.asList("Admin","IT","HR"));
		list.stream().forEach(arr->System.out.println(Arrays.toString(arr)));
		
	}
	
	private void createEmpoyee() {
		List<Employee> emplist =Arrays.asList(
				// Admin dept
				Employee.create("Ram", "Admin", 200000),
				Employee.create("Tom", "Admin", 400000),
				
				// Sales Dept
				Employee.create("Sita", "sale", 500000),
				Employee.create("geeta", "sale", 800000),
				
				// IT Dept
				Employee.create("Ganu", "IT", 5600000),
				Employee.create("Damu", "IT", 8900000),
				
				// Hr Dept
				Employee.create("Neha", "Hr", 510000),
				Employee.create("Sneha", "Hr", 180000)
				);
		
		Iterable<Employee> employeelist = personService.saveAllEmployee(emplist);
		for (Employee emp : employeelist) {
			System.out.println("Employee Object :"+ emp.toString() );
		}
	}	
	
	private void retriveByBookName() {
		Iterable<Book> book = personService.retriveByBookName("Mrutunjay");
		for (Book bookname : book) {
			System.out.println("Person Object :"+ book.toString() );
		}
	}

	private void createPerson() {
		
		List<Person> personList = Arrays.asList(
				new Person("AAA", "AAA", "AAA@gmai.com", 20),
				new Person("BBB", "BBB", "BBB@gmai.com", 43),
				new Person("CCC", "CCC", "CCC@gmai.com", 90),
				new Person("DDD", "DDD", "DDD@gmai.com", 89),
				new Person("EEE", "EEE", "EEE@gmai.com", 20)
//				new Person("som", "som", "som@gmai.com", 98),
//				new Person("pinay", "pinay", "pinay@gmai.com", 20),
//				new Person("linay", "linay", "linay@gmai.com", 49),
//				new Person("minay", "minay", "minay@gmai.com", 70),
//				new Person("minay", "minay", "minay@gmai.com", 20)
				);
		
		Iterable<Person> list = personService.saveAllParsons(personList);
		for (Person person : list) {
			System.out.println("Person Object :"+ person.toString() );
		}
	}
	
//       private void getPersonBYId() {
//      	List<Integer> personList = new ArrayList<Integer>();
//	personList.add(1);
//	personList.add(3);
//	personList.add(4);
//	personList.add(5);
//	personList.add(7);
//	personList.add(8);
//	personList.add(9);
//	
//	// findPerson
//	Iterable<Person> personsList = personService.getMultipleParsons(personList);
//	for (Person person : personsList) {
//		System.out.println("Person Object :"+ person.toString() );
//	}
//}
	
	private	 void findByLastNameOrFirstName() {
		Iterable<Person> personList = personService.findByLastNameOrFirstName("minay", "minay");
		for(Person person :personList) {
			System.out.println("Person object :"+ person.toString());
		}
	}
	
	private	 void findByLastNameAndFirstName() {
	  Person person = personService.findByLastNameAndFirstName("vinay", "vinay");
	  System.out.println("Person object :"+ person.toString());
	}
	
	private void findByLastNameOrderByCreatedDateDesc(){
		 List<Person> personList = personService.findByLastNameOrderByCreatedDateDesc("minay");
		 for(Person person :personList) {
				System.out.println("Person object :"+ person.toString());
			}
	}
	
	private void findByAgeLessThanEqual()	{
		List<Person> personList = personService.findByAgeLessThanEqual(70);
		for(Person person :personList) {
			System.out.println("Person object :"+ person.toString());
		}
	}
	
	private void findByFirstNameLike() {
		List<Person> personList = personService.findByFirstNameLike("%pinay%");
		for(Person person :personList) {
			System.out.println("Person object :"+ person.toString());
		}
	}
	
	private void findByLastNameAndAgeLessThanEqual(){
			List<Person> personList = personService.findByLastNameAndAgeLessThanEqual("minay", 50);
			for(Person person :personList) {
				System.out.println("Person object :"+ person.toString());
			}
		}
		
		
		private void findByCreatedDateBetween(){
			List<Person> personList = personService.findByCreatedDateBetween(getDateWithTime("2026-04-02 12:12:19.027000"),
					                                                         getDateWithTime("2026-04-02 20:44:42.895000"));
			for(Person person :personList) {
				System.out.println("Person object :"+ person.toString());
			}
		}
		
		private Date getDateWithTime(String dateString) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				return format.parse(dateString);
			}catch(Exception e){
				throw new RuntimeException(e);
			}
		}
		
	   private void	giveDataByLast() {
		   Iterable<Person> personList = personService.giveDataByLastName("vinay");
		   for(Person person :personList) {
				System.out.println("Person object :"+ person.toString());
			}
	   }
}

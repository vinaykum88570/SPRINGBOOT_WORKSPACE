 package com.springboot;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.scheduling.annotation.EnableAsync;

import com.springboot.model.Book;
import com.springboot.model.CustomType;
import com.springboot.model.Employee;
import com.springboot.model.Person;
import com.springboot.service.PersonService;

@SpringBootApplication
@EnableAsync  // This Annoatation will create a default infrastructure for asyncronous operation
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
//		giveFewColumns();
//		findPersonInfoFirstNameOrEmail();
//		findPersonInfoByFirstName();
//		displayPagination();
//		 runsync() ;
		runAsync();
		
	}
	 
	 // Asyncronous
	 private void  runAsync() throws InterruptedException,ExecutionException{
		 
		 long start = System.currentTimeMillis();// 120ms 
		 // kick of multiple , asyncronous lookup
		 CompletableFuture<Person> obj1 = personService.findByemail("pooja@gmail.com");
		 // The following statement will be printed only after the execution of above method findByEmail
		 
		 // Execution of the Methods findByEmail
		 System.out.println("Personal call completed");
		 
		 CompletableFuture<Person> obj2 = personService.findByemail("sachin@");
		 System.out.println("Personal call completed 2");
		 
		 CompletableFuture<Person> obj3 = personService.findByemail("vijay@");
		 System.out.println("Personal call completed 3");
		 
		 CompletableFuture<Person> obj4 = personService.findByemail("vinay@");
		 System.out.println("Personal call completed 4");
		
		 
		 // wait untill they are done 
		 CompletableFuture.allOf(obj1,obj2,obj3,obj4).join();
		 
		 // print result they are all done 
		System.out.println("-->"+ obj1.get());
		System.out.println("-->"+ obj2.get());
		System.out.println("-->"+ obj3.get());
		System.out.println("-->"+ obj4.get());
		
		System.out.println("Elapsed Time  :"+( System.currentTimeMillis() - start));
	 }
	
	  // syncronous
	 private void  runsync() throws InterruptedException,ExecutionException{
		 
		 long start = System.currentTimeMillis();// 120ms 
		 // kick of multiple , asyncronous lookup
		 List<Person> person1 = personService.findByEmail("pooja@gmail.com");
		 // The following statement will be printed only after the execution of above method findByEmail
		 
		 // Execution of the Methods findByEmail
		 System.out.println("Personal call completed");
		 
		 List<Person> person2 = personService.findByEmail("sachin@");
		 System.out.println("Personal call completed 2");
		 
		 List<Person> person3 = personService.findByEmail("vijay@");
		 System.out.println("Personal call completed 3");
		 
		 List<Person> person4 = personService.findByEmail("vinay@");
		 System.out.println("Personal call completed 4");
		 
		 person1.forEach(System.out::println);
		 person2.forEach(System.out::println);
		 person3.forEach(System.out::println);
		 person4.forEach(System.out::println);
		 
		 System.out.println("Total Time took :"+( System.currentTimeMillis()-start));
		 
	 }
	
	   // Pagenation
	   private void  displayPagination() {
		   /*
		   System.out.println("Pagenation Without Sorting");
		   List<Person> noSortList = personService.findByLastName("vinay", PageRequest.of(0, 4));
		   // Select * from person where last_Name = "vinay" where RowNumber>=0 AND RowNumber<=4
		   
		   noSortList.forEach(System.out::println);
		*/   
		   
		   System.out.println("First Page......................................");
		   Iterable<Person> firstlist = personService.findByLastName("vinay", PageRequest.of(0,3,Direction.ASC,"lastName"));
		   
		   // Select * from person where last_Name = "vinay" and RowNumber>=0 AND RowNumber<=3
		   // 0 -> offset 
		   // 3 --> page size 
		   // order of sorting  ASC/DESC
		   // which  column name order 
//		   
//		   for (Person person : list) {
//				System.out.println("Person Object :"+ person.toString() );
//			}
		   firstlist.forEach(System.out::println);
		   
		   
		   System.out.println("Second Page......................................");
		   Iterable<Person> secondlist = personService.findByLastName("vinay", PageRequest.of(1,3,Direction.ASC,"lastName"));
		   
		   // Select * from person where last_Name = "vinay" and RowNumber>=0 AND RowNumber<=3
		   // 0 -> offset 
		   // 3 --> page size 
		   // order of sorting  ASC/DESC
  
		   secondlist.forEach(System.out::println);
		   
		   
		   System.out.println("Third Page......................................");
		   Iterable<Person> thirdlist = personService.findByLastName("vinay", PageRequest.of(2,3,Direction.ASC,"lastName"));
		   
		   thirdlist.forEach(System.out::println);
		   
		   
		   System.out.println("Fourth Page......................................");
		   Iterable<Person> fourthlist = personService.findByLastName("vinay", PageRequest.of(3,3,Direction.ASC,"lastName"));
		   
		   fourthlist.forEach(System.out::println);
		   
		   
		   
	   }
	
	    // Query 
		private void findPersonInfoFirstNameOrEmail(){
			List<Person> perosnlist = personService.findPersonInfoFirstNameOrEmail("AAA", "AAA");
			for (Person person : perosnlist) {
				System.out.println("Person Object :"+ person.toString() );
			}
		}
		
		// Native Query
		private void  findPersonInfoByFirstName(){
		   List<Person> personList = personService.findPersonInfoByFirstName("BBB");
		   for (Person person : personList) {
				System.out.println("Person Object :"+ person.toString() );
			}
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

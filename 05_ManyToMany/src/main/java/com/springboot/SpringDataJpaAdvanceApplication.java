package com.springboot;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.model.Book;
import com.springboot.model.Publisher;
import com.springboot.service.Service;

@SpringBootApplication
public class SpringDataJpaAdvanceApplication implements CommandLineRunner {

	@Autowired
	private Service personService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaAdvanceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		saveBookPublishers();
		findByBookName();
	}
	
	
	
	
	private void findByBookName() {
		Iterable<Book> bookName = personService.findByBookName("Chava");
		for (Book book : bookName) {
			System.out.println(book.toString());
		}
	}
	
	private void saveBookPublishers() {
		Publisher publisherA = new Publisher("Abdul kalam");
		Publisher publisherB = new Publisher("stephon kovey");
		Publisher publisherC = new Publisher("Chetan Bhhgat");
		Publisher publisherD = new Publisher("Shivaji savant");
		Publisher publisherE = new Publisher("vikas ravat");
		Publisher publisherF = new Publisher("Lata Mangeshkar");
		
		// One to One from Book to Publisher 
		Book book1 = new Book("WingsFire", new HashSet<>(Arrays.asList(publisherA)));
		Book book2 = new Book("seven Habit", new HashSet<>(Arrays.asList(publisherB)));
		Book book3 = new Book("Two states", new HashSet<>(Arrays.asList(publisherC)));
		
		// One To Many from Book to Publisher
		Book book4 =  new Book("Chava", new HashSet<>(Arrays.asList(publisherD,publisherE)));
		
		// One To Many from Publisher to Book
		Book book5 =  new Book("Mrutunjay", new HashSet<>(Arrays.asList(publisherF)));
		Book book6 =  new Book("Yugandhar", new HashSet<>(Arrays.asList(publisherF)));
	
		// many To Many
		personService.saveBooks(Arrays.asList(book1, book2 ,book3 ,book4 ,book5 ,book6 ));
		
	}


}

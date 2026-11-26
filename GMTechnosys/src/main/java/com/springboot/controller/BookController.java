package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Book;
import com.springboot.service.BookService;

@RestController
@RequestMapping("api/books")
public class BookController {

	@Autowired
	private BookService bookService;
//	Q2. Books by Author [10 Marks]
//			Scenario: A library application needs to list all books written by one author. Implement GET
//			/api/books/author/{author}.
//
//			Paper Set 02 – Page 1
//
//			GM TECHNOSYS | Java Full Stack Developer (Intern) | Paper Set 02
//
//			
//			@Entity
//			public class Book {
//			@Id @GeneratedValue private Long id;
//			private String title;
//			private String author;
//			private Double price;
//			}
	
//			Requirements:
//			• Take the author name from the URL.
//			• Create a repository method that finds books by author using Spring Data JPA naming (no @Query needed).
//			• Return the list of books. If the author has no books, return an empty list (not an error).
	
	@GetMapping("/author/{author}")
	public List<Book> getAuthor(@PathVariable String author){
		return bookService.getAuthor(author);
	}
	
	
}

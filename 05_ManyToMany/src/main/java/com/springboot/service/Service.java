package com.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.Dao.BookDao;
import com.springboot.model.Book;

@org.springframework.stereotype.Service
public class Service {
	
	
	@Autowired 
	private BookDao BookRepository;
	
	public Iterable<Book> findByBookName(String bookName){
		return BookRepository.findByBookName(bookName);
	}
	
	public Iterable<Book> saveBooks(Iterable<Book> bookslist){
		return BookRepository.saveAll(bookslist);
	}
	
	public Iterable<Book> findBooks(){
		return BookRepository.findAll();
	}
	
}

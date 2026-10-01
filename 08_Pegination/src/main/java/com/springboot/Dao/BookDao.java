package com.springboot.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.Book;

@Repository
public interface BookDao extends CrudRepository<Book, Integer> {

	public Iterable<Book> findByBookName(String bookName);
	
	// select * from book join publisher join book_publisher
	
	
	// Named Query Section
	public Iterable<Book> retriveByBookName(String bookName);
	
	
}

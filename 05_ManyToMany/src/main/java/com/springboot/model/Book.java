package com.springboot.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_book")
public class Book {

	@Id
	@Column(name="book_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookId;
	
	@Column(name="book_name")
	private String bookName;
	
	/*
	 * CascadeType.All ==>Any DML (Select , insert , update , delete  ) operation  it will cascade  to publisher also 
	 * fetch ==> FetchType.EAGER ==> Both Parent and  Child 
	 * fetch ==> FetchType.LAZY ===> Only parent , on demand child
	 */
	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="book_publisher",
	              joinColumns = @JoinColumn(name="bookId",referencedColumnName ="book_id"),
	              inverseJoinColumns = @JoinColumn(name="publisherId",referencedColumnName ="publisher_id"))
	private Set<Publisher> publishers;

	
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	public Book( String bookName, Set<Publisher> publishers) {
		super();
		
		this.bookName = bookName;
		this.publishers = publishers;
	}



	public Integer getBookId() {
		return bookId;
	}



	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}



	public String getBookName() {
		return bookName;
	}



	public void setBookName(String bookName) {
		this.bookName = bookName;
	}



	public Set<Publisher> getPublishers() {
		return publishers;
	}



	public void setPublishers(Set<Publisher> publishers) {
		this.publishers = publishers;
	}

		
	
	// Customize to string 
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + "]";
	}
	
}

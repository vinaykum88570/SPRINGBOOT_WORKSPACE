	package com.springboot.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_publisher")
public class Publisher {



	@Id
	@Column(name="publisher_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer publisherId;
	
	@Column(name="publisher_name")
	private String publisherName;
	
	
	// Already relationship is Exists and it will bridge the relation
	@ManyToMany(mappedBy ="publishers")
	private Set<Book> books;

	public Publisher() {
		
	}

	public Publisher(String publisherName, Set<Book> books) {
		super();
		this.publisherName = publisherName;
		this.books = books;
	}


	public Publisher(String publisherName) {
		this.publisherName = publisherName;
	}

	public Integer getPublisherId() {
		return publisherId;
	}


	public void setPublisherId(Integer publisherId) {
		this.publisherId = publisherId;
	}


	public String getPublisherName() {
		return publisherName;
	}


	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}


	public Set<Book> getBooks() {
		return books;
	}


	public void setBooks(Set<Book> books) {
		this.books = books;
	}
		
	
	
}

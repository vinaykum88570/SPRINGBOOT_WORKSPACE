package com.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Book {
	
	@Id 
	@GeneratedValue 
	private Long id;
	private String title;
	private String author;
	private Double price;
	
}
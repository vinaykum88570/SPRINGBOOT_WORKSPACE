package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.enity.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Integer> {

	
	
}

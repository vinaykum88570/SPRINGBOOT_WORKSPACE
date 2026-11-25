package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.enity.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Integer> {

	public Ticket getTicket(Integer id);

	public Iterable<Ticket> getAllTicket();

	public Ticket getByName(String name);
	

	
}

package com.example.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.enity.Ticket;
import com.example.repository.TicketRepository;

@Service
public class TicketService {
	
	@Autowired
	private TicketRepository repository;
	
	public Ticket getTicket(Integer id) {
		return repository.getTicket(id);
	}

	public Iterable<Ticket> getAllTicket() {
		return repository.getAllTicket();
	}

	public Ticket getName(String name) {
	    return repository.getByName(name);
	}


}

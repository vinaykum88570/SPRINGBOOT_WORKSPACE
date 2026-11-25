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

	public Ticket createTicket(Ticket ticket) {
		
		return repository.save(ticket);
	}

	public Ticket getTicket(Integer id) {
		return repository.findById(id).get();
	}

	public Iterable<Ticket> createMutiTicket(List<Ticket> tickets) {
		 for (Ticket ticket : tickets) {
		        ticket.setTravel_date(new Date());
		    }
		return repository.saveAll(tickets);
	}

	public void deleteID(Integer id) {
	 repository.deleteById(id);
	}
}

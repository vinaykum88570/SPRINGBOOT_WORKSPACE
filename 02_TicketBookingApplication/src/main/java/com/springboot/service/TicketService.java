package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dao.TicketDaoRepository;
import com.springboot.entity.Ticket;

@Service
public class TicketService {

	@Autowired
	private TicketDaoRepository ticketDaoService;
	
	// Retrive All ticket 
	public Iterable<Ticket> getAllticket() {
		return ticketDaoService.findAll();
	}
	
	// Retrive Individuals ticket 
	public Ticket getTicket(Integer ticketId) {
		return ticketDaoService.findById(ticketId).orElse(new Ticket());
	}
	
	// Create ticket 
	public Ticket createTicket(Ticket ticketObj) {
		return ticketDaoService.save(ticketObj);
	}
	
	// Update ticket
	public Ticket updateTicket(Integer ticketid, String newEmail) {
		// save Methods ==> both Insert and Update.
		
		Ticket ticketObj = getTicket(ticketid);
		ticketObj.setEmail(newEmail);
		
		return ticketDaoService.save(ticketObj);
	}
	
	//Delete Ticket
	public void deleteTicket(Integer ticketid) {
		ticketDaoService.deleteById(ticketid);
	}
	
	// Retrive Ticcket Based On passenger name
	public List<Ticket> getByPassengerName(String passengerName) {
		return ticketDaoService.findByPassengerName(passengerName);	
	}
	
	
	
}

package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.enity.Ticket;
import com.example.service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	
	@Autowired
	private TicketService service;

	@PostMapping("/create")
	public Ticket createTicket(@RequestBody Ticket ticket) {
		return service.createTicket(ticket);
	}
	
	@GetMapping("/get/{id}")
	public Ticket getTicket(@PathVariable Integer id) {
		return service.getTicket(id);
	}
	
	@PostMapping("/createAll")
	public Iterable<Ticket> createMultiTicket(@RequestBody List<Ticket> tickets ){
		return service.createMutiTicket(tickets);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteId(@PathVariable Integer id) {
		service.deleteID(id);
	}
	
	@GetMapping("/getAll")
    public Iterable<Ticket> getAllTickets(){
    	return service.getAllTicket();
    }
	
	

}

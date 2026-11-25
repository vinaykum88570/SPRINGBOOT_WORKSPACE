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
	
	@GetMapping("/get/{id}")
	public Ticket getTicket(@PathVariable Integer id) {
		return service.getTicket(id);
	}
	
	@GetMapping("/getAll")
    public Iterable<Ticket> getAllTickets(){
    	return service.getAllTicket();
    }
	
	@GetMapping("/getName/{name}")
	public Ticket getName(@PathVariable String name) {
		return service.getName(name);
	}
	
}

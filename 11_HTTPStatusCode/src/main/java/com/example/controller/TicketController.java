package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<?> getTicket(@PathVariable Integer id) {
		Ticket ticket = service.getTicket(id);
	    if (ticket == null) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ticket not found with id: " + id);
	    }
	  return ResponseEntity.ok(ticket);
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
    public ResponseEntity<List<Ticket>> getAllTickets(){
		List<Ticket> list = service.getAllTicket();
		
		if(list.size()<=0) 
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
    	return ResponseEntity.of(Optional.of(list));
    }
	
	

}

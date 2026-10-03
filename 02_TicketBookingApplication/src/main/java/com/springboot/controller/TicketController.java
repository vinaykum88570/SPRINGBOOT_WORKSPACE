package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Ticket;
import com.springboot.service.TicketService;

@RestController
@RequestMapping(value="/ticket")
// http://localhost:8080/ticket ==> DispatcherServlet will Instatiate the TicketController
public class TicketController {
    // Controller vs RestController
	//1. Controller -> Used mainly for MVC application and returning UI/ View Pages.
	/* Return HTML / JSP / Thymeleaf views
	 * Used for web(browser) applications
	 * Works with ViewResolver
	 * */
	
	//2. RestController -> Used For building REST APIs and returning data such as JSON.
	/* Return data (JSON/XML)
	 * Used for RESTful web services
	 * Automatically includes @ResponseBody
	 * */
	
	@Autowired
	private TicketService service;
	
	// create ticket
	@PostMapping(value="/create")
	public Ticket createTicket(@RequestBody Ticket ticketObj) {
		
		return service.createTicket(ticketObj);
	}
		
		
	// get ticket
	@GetMapping(value="/get/{ticketId}")
	public Ticket getTicket(@PathVariable("ticketId") Integer ticketId) {
		return service.getTicket(ticketId);
		}
		
	// get all ticket
	@GetMapping(value="/all")
	public Iterable<Ticket> getAllticket(){
		return service.getAllticket();
	}
	

	// Update ticket 
	@PutMapping(value="/{ticketid}/{newEmail}")
	public Ticket updateTicket(@PathVariable("ticketid") Integer ticketid,
			                   @PathVariable("newEmail") String newEmail) {
		return service.updateTicket(ticketid, newEmail);
	}
	
	// delete ticket
	@DeleteMapping(value="/delete/{ticketid}")
	public void deleteTicket(@PathVariable("ticketid") Integer ticketid) {
		service.deleteTicket(ticketid);
	}	
	
	
	// Find by passenger name
	@GetMapping(value="/pname/{passengerName}")
	public List<Ticket> getTicketByPassengerName(@PathVariable("passengerName") String passengerName ) {
		return service.getByPassengerName(passengerName);
	}
	
	
}


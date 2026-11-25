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

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	
	@Autowired
	private TicketService service;

	@GetMapping("/getName/{name}")
	public Ticket getByName(@PathVariable String name) {
		return service.getByName(name);
	}
	

}

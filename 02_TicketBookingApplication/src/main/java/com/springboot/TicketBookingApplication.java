package com.springboot;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.entity.Ticket;
import com.springboot.service.TicketService;

@SpringBootApplication
public class TicketBookingApplication implements CommandLineRunner {

	
	@Autowired
	private TicketService ticketService;
	
	public static void main(String[] args) {
		SpringApplication.run(TicketBookingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Ticket obj = new Ticket();
		obj.setPassengerName("Sunil");
		obj.setSourceStation("Goa");
		obj.setDesignationStation("Tripura");
		obj.setEmail("naresh@gmail.com");
		obj.setTravelDate(new Date());
		ticketService.createTicket(obj);
		
		System.out.println("Hello");
		
	}

}

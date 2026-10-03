	package com.springboot.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.entity.Ticket;

@Repository
public interface TicketDaoRepository  extends CrudRepository<Ticket, Integer>{

	
	// Derived methods 
	public List<Ticket> findByPassengerName(String passengerName);
	
}

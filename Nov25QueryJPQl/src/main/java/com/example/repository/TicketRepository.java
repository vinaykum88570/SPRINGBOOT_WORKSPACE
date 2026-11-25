package com.example.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.enity.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Integer> {

	@Query("select s from Ticket s where s.passenger_name =:name")
	public Ticket getByName(@Param("name") String name);
	
}

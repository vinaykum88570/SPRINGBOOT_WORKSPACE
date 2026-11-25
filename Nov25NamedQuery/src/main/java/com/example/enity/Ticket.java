package com.example.enity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_ticket")

@NamedQueries({ 
	
	@NamedQuery(
	    name = "Ticket.getTicket",
	    query = "SELECT s FROM Ticket s WHERE s.ticket_id =:id"
    ),
	
   @NamedQuery(
	    name = "Ticket.getAllTicket",
	    query = "SELECT s FROM Ticket s"
   ),
   
   @NamedQuery(
		 name="Ticket.getByName",
		 query= "select s from Ticket s where s.passenger_name=:name"
		   )
	
})
   
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer ticket_id;
	private String designation_station;
	private String email;
	private String passenger_name;
	private String source_station;
	private Date travel_date;
	

	
	public Integer getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(Integer ticket_id) {
		this.ticket_id = ticket_id;
	}
	public String getDesignation_station() {
		return designation_station;
	}
	public void setDesignation_station(String designation_station) {
		this.designation_station = designation_station;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassenger_name() {
		return passenger_name;
	}
	public void setPassenger_name(String passenger_name) {
		this.passenger_name = passenger_name;
	}
	public String getSource_station() {
		return source_station;
	}
	public void setSource_station(String source_station) {
		this.source_station = source_station;
	}
	public Date getTravel_date() {
		return travel_date;
	}
	public void setTravel_date(Date travel_date) {
		this.travel_date = travel_date;
	}
	
	
}

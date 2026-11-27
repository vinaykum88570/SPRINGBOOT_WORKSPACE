package com.example.enity;

import java.util.Date;
import java.util.List;

import org.yaml.snakeyaml.events.Event.ID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_ticket")
public class Ticket  {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer ticket_id;
	private String designation_station;
	private String email;
	private String passenger_name;
	private String source_station;
	private Date travel_date;
	
	
	
	@Override
	public String toString() {
		return "Ticket [ticket_id=" + ticket_id + ", designation_station=" + designation_station + ", email=" + email
				+ ", passenger_name=" + passenger_name + ", source_station=" + source_station + ", travel_date="
				+ travel_date + "]";
	}
	public Ticket() {
		
	}
	public Ticket(Integer ticket_id, String designation_station, String email, String passenger_name,
			String source_station, Date travel_date) {
		super();
		this.ticket_id = ticket_id;
		this.designation_station = designation_station;
		this.email = email;
		this.passenger_name = passenger_name;
		this.source_station = source_station;
		this.travel_date = travel_date;
	}
	
	
	public Ticket(String designation_station, String email, String passenger_name, String source_station,
			Date travel_date) {
		super();
		this.designation_station = designation_station;
		this.email = email;
		this.passenger_name = passenger_name;
		this.source_station = source_station;
		this.travel_date = travel_date;
	}


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

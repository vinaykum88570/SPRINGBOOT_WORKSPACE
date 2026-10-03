package com.springboot.entity;

import java.util.Date;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="tbl_ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ticket_id")
	private Integer ticketId;
	
	@Column(name="passenger_name")
	private String passengerName;
	
	@Column(name="source_station")
	private String sourceStation;
	
	@Column(name="designation_station")
	private String designationStation;
	
	@Column(name="travel_date")
	private Date travelDate;
	
	private String email;
	
	

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getSourceStation() {
		return sourceStation;
	}

	public void setSourceStation(String sourceStation) {
		this.sourceStation = sourceStation;
	}

	public String getDesignationStation() {
		return designationStation;
	}

	public void setDesignationStation(String designationStation) {
		this.designationStation = designationStation;
	}

	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Ticket() {
			
	}

	public Ticket(String passengerName, String sourceStation, String designationStation, String email) {
		super();
		this.ticketId = ticketId;
		this.passengerName = passengerName;
		this.sourceStation = sourceStation;
		this.designationStation = designationStation;
		this.travelDate = new Date();
		this.email = email;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", passengerName=" + passengerName + ", sourceStation=" + sourceStation
				+ ", designationStation=" + designationStation + ", travelDate=" + travelDate + ", email=" + email
				+ "]";
	}
	
	
	
	
	
}

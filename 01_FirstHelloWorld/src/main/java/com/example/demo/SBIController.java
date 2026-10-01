package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SBIController {

	// parsonal Loan 
	@RequestMapping(value="/sbi/parsonal")
	public String getParsonalLoan() {
		return "Reached to parsonal Loan section";
	}
	
	// Home loan 
	@RequestMapping(value="/sbi/home")
	public String getHomeLoan() {
		return "Reached to Home loan section";
	}
	// saving account 
	@RequestMapping(value="/sbi/saving")
	public String getsavingAccount() {
		return "Reached to saving account  section";
	}
	
	// current Account
	@RequestMapping(value="/sbi/current")
	public String getCurrentAccount() {
		return "Reached to current Account section";
	}
	
}

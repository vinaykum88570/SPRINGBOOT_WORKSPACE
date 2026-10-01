package com.springboot.services;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.model.Employee;
import com.springboot.model.Insurance;

import jakarta.transaction.Transactional;

@Service
public class OrganizationService {

	@Autowired
	private EmployeeServices empService;
	
	
	@Autowired
	private InsuranceServices insService;
	
	@Transactional 
	// This will create temparary memory block 
	// Default Propagation ==>REQUIRED ==> Always Creates Transaction Block
	// If parent has a Transaction block and child has either transaction or no transaction ==> only parent can control
	public void onBoardEmployee(Employee empObj, Insurance insObj) {
		
		empService.saveEmployee(empObj); // DMl 1
		if(insObj.getschemaName().length() <= 4) {
			throw new RuntimeErrorException(null,"Exception in Insurance");
			
		}
		else
		{
			insObj.setEmpId(empObj.getEmpId());
			insService.registerInsurance(insObj); // DML 2
		}
		
	}
}

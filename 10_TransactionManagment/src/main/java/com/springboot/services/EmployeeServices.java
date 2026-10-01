package com.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dao.EmployeeDao;
import com.springboot.model.Employee;

@Service
public class EmployeeServices {

	@Autowired
	private EmployeeDao empdao;
	
	public Employee saveEmployee(Employee emp) {
	
		return empdao.save(emp);
	}
}

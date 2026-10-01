package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.model.Employee;
import com.springboot.model.Insurance;
import com.springboot.services.OrganizationService;

@SpringBootApplication
public class TransactionManagmentApplication implements CommandLineRunner {

	@Autowired
	private OrganizationService orgService;
	
	public static void main(String[] args) {
		SpringApplication.run(TransactionManagmentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		Employee emp = new Employee();
		emp.setEmpName("vijay");
		
		Insurance ins = new Insurance();
		ins.setschemaName("CovidTopUp");
		ins.setCoverageAmmount(300000);
		
		orgService.onBoardEmployee(emp, ins);
	}

}

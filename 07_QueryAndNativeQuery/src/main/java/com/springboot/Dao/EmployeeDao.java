package com.springboot.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.Employee;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Long> {

	
	// Named Query 
	public List<Object[]> getMaxSalaryByDept(List<String> deptNames);
}

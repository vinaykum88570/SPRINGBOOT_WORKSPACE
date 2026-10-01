package com.springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_employee")
@NamedQueries(value= {
		 
		/* Named Query 1  --> select b from book inner join 
		 *                    book_publisher bp on b.book_id=bp.book_id	inner join	
		 *                    publisher p on bp.publisher_id=p. publisher_id */
		@NamedQuery(name="Employee.getMaxSalaryByDept",
				    query="select e.dept,max(e.salary) from Employee e group by e.dept having e.dept in ?1")
		/* ?1 ==> List<String>  ==> Admin,HR or HR ,IT
		 * 
		 * 
		 * */
})
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String dept;
	private int salary;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String name, String dept, int salary) {
		super();
		this.name = name;
		this.dept = dept;
		this.salary = salary;
	}
	
	public static Employee create(String name, String dept, int salary) {
	Employee e= new Employee();
	e.setName(name);
	e.setDept(dept);
	e.setSalary(salary);
	return e;
		
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dept=" + dept + ", salary=" + salary + "]";
	}
	
}

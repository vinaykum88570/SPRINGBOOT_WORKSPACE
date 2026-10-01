package com.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tm_insurance")
public class Insurance {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ins_id")
	private Integer insuranceId;
	
	@Column(name="ins_name")
	private String schemaName;
	
	@Column(name="emp_id")
	private Integer empId;
	
	@Column(name="cov_amount")
	private Integer coverageAmmount;

	public Integer getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(Integer insuranceId) {
		this.insuranceId = insuranceId;
	}

	public String getschemaName() {
		return schemaName;
	}

	public void setschemaName(String schemaName) {
		this.schemaName = schemaName;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public Integer getCoverageAmmount() {
		return coverageAmmount;
	}

	public void setCoverageAmmount(Integer coverageAmmount) {
		this.coverageAmmount = coverageAmmount;
	}

	public Insurance(String schemaName, Integer empId, Integer coverageAmmount) {
		super();
		this.schemaName = schemaName;
		this.empId = empId;
		this.coverageAmmount = coverageAmmount;
	}


	public Insurance() {
		
	}

	@Override
	public String toString() {
		return "Insurance [insuranceId=" + insuranceId + ", schemaName=" + schemaName + ", empId=" + empId
				+ ", coverageAmmount=" + coverageAmmount + "]";
	}
	
}

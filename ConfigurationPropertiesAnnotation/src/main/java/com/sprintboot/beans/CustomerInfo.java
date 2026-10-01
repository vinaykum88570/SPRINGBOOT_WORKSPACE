package com.sprintboot.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component("custInfo")
@ConfigurationProperties(prefix="cust.info")

public class CustomerInfo {

	private String name;
	
	private int age;

	private String addr;
	
	private float billAmt;

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public float getBillAmt() {
		return billAmt;
	}

	public void setBillAmt(float billAmt) {
		this.billAmt = billAmt;
	}



	@Override
	public String toString() {
		return "CustomerInfo [name=" + name + ", age=" + age + ", addr=" + addr + ", billAmt=" + billAmt + "]";
	}
	
	
	
		
	
}

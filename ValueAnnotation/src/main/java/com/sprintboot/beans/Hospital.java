package com.sprintboot.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("hsptl")
@Data
public class Hospital {

	@Value("KIMS")      // hard coded
	private String name;
	
	@Value("30")       // hard coded
	private String rank;
	
	@Value("${hsptl.name}") // Collecting for properties file 
	private String name1;
	
	@Value("${hsptl.age}")  // Collecting for properties file 
	private int age;
	
	
	@Value("${Path}")       //injecting from env variable
	private String pathData;
	
	@Value("${os.name}")  //injecting System properties value
	private String os;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPathData() {
		return pathData;
	}

	public void setPathData(String pathData) {
		this.pathData = pathData;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}
	
		
	
}

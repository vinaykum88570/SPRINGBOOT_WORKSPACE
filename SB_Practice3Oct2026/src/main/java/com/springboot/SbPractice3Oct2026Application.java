package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.springboot.entity.Student;
import com.springboot.service.StudentService;

@SpringBootApplication
public class SbPractice3Oct2026Application implements CommandLineRunner {

	@Autowired
	private StudentService studentService;
	
	public static void main(String[] args) {
		SpringApplication.run(SbPractice3Oct2026Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		getStudent(1);
		
	}

	public void getStudent(Integer id) {
		Student student = studentService.getStudent(id);
		student.toString();
	}


	
	
	

}

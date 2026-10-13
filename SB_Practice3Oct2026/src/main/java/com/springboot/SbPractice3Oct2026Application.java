package com.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.springboot.entity.Student;
import com.springboot.repository.StudentRepository;
import com.springboot.service.StudentService;

@SpringBootApplication
public class SbPractice3Oct2026Application implements CommandLineRunner {

	@Autowired
	private StudentService studentService;
	@Autowired
	private StudentRepository studentRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SbPractice3Oct2026Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
//		getStudent(1);
//		List<Student> all = studentRepository.getAll();
//		for (Student student : all) {
//			System.out.println(student);
//		}
		
//		List<Student> studentByName = studentRepository.getStudentByName("Dev");
//		for (Student student : studentByName) {
//			System.out.println(student);
//		}
		
//		List<Student> allStudent = studentRepository.getAllStudent();
//		for (Student student : allStudent) {
//			System.out.println(student);
//		}
	}

	public void getStudent(Integer id) {
		Student student = studentService.getStudent(id);
		System.out.println(student.getId());
		System.out.println(student.getEmail());
		System.out.println(student.getName());
		System.out.println(student.getPhoneNo());
		System.out.println(student.getAge());
		
	}

   
	
	
	

}

package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Student;
import com.springboot.repository.StudentRepository;
import com.springboot.service.StudentService;

@RestController
@RequestMapping("/stu")
public class StudentController {

	private final StudentRepository studentRepository;
	@Autowired
    private StudentService studentService;

	StudentController(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
    //	http://localhost:8080/stu/get/3
	@GetMapping("/get/{id}")
	public Student getStudent(@PathVariable Integer id) {
		return studentService.getStudent(id);
	}
	
	// http://localhost:8080/stu/get/all
	@GetMapping("/get/all")
	public Iterable<Student> getAllStu(){
		return studentService.getAllStu();
	}
	
	// http://localhost:8080/stu/update/1/vinay/vinay@gmail.com/22/8857056070
	@PutMapping("/update/{id}/{name}/{email}/{age}/{phoneno}")
	public Student update(@PathVariable Integer id,
			              @PathVariable String name,
			              @PathVariable String email,
			              @PathVariable int age,
			              @PathVariable long phoneno
			              ) {
		return studentService.updateStu(id,name,email,age,phoneno);
	}
		
	// Using PATCH Method
	// http://localhost:8080/stu/update/kumdale/1
	@PatchMapping("/update/{name}/{id}")
	public void updateName(@PathVariable String name,@PathVariable Integer id) {
		studentService.updateName(id, name);
	}
	
	
		
	
	
}

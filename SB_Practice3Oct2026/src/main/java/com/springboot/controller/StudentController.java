package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Student;
import com.springboot.repository.StudentRepository;

@RestController
@RequestMapping("/stu")
public class StudentController {

	@Autowired
    private StudentRepository studentRepository;
	
	@GetMapping("/get/sid")
	public Student getStudent(Integer sid) {
		return studentRepository.findById(sid).get();
	}
	
}

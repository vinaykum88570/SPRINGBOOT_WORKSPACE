package com.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.Student;
import com.springboot.repository.StudentRepository;
 
@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	// Find By ID
	public Student getStudent(Integer id) {
		return studentRepository.findById(id).get();
		
	}

	// Find By All 
	public Iterable<Student> getAllStu(){
		return studentRepository.findAll();
	}

	// Update some Info Using ID
	public Student updateStu(Integer id, String name, String email, int age, long phoneno) {
		Student student = studentRepository.findById(id).get();
		student.setName(name);
		student.setEmail(email);
		student.setAge(age);
		student.setPhoneNo(phoneno);
		
		return studentRepository.save(student);
	}
	
	// Update Using patch
	public void updateName(Integer id, String name) {
			Student student = studentRepository.findById(id).get();
			student.setName(name);
			studentRepository.save(student);
	}
}

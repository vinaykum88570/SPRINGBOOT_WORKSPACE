package com.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.entity.Student;
import com.springboot.repository.StudentRepository;

@Service
public class StudentService {

	private StudentRepository studentRepository;
	
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository=studentRepository;
	}
	
	public Student createStudent(Student student) {
		Student studentResp = studentRepository.save(student);
		return studentResp;
	}

	public Student getStudent(Long id) {
		Optional<Student> studentResp = studentRepository.findById(id);
		
		if(studentResp.isPresent()) {
			return studentResp.get();
		}
		
	  return null;	
	}

	public List<Student> getAllStudent() {
		List<Student> listOfStudents = studentRepository.findAll();
		return listOfStudents;
	}

	public Student updateStudent(Long id, Student studentReq) {
		Optional<Student> existingStudent = studentRepository.findById(id);
		
		if(existingStudent.isEmpty()) {
			return null;
		}
		
		Student studentToSave = existingStudent.get();
		studentToSave.setName(studentReq.getName());
		studentToSave.setRollNo(studentReq.getRollNo());
		studentToSave.setSubject(studentReq.getSubject());
		studentToSave.setEmail(studentReq.getEmail());
		studentToSave.setAge(studentReq.getAge());
		return studentRepository.save(studentToSave);
	}

	public Boolean deleteStudent(Long id) {
		Boolean isStudent = studentRepository.existsById(id);
		
			if(!isStudent) {
				return false;
			}
			
			 studentRepository.deleteById(id);
		
		return true;
	}

	
	
}

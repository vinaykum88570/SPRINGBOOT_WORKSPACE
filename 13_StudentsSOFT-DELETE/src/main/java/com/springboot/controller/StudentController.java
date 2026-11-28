package com.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Student;
import com.springboot.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	private StudentService studentService;
	
	public StudentController(StudentService studentService) {
		this.studentService=studentService;
	}
	
	// soft delete Implement Is deleted = student.setDeleted(false);
	@PostMapping("/create")
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		Student createdStduent = studentService.createStudent(student);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(createdStduent);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Student> getStudennt(@PathVariable Long id){
		Student studentResp= studentService.getStudent(id);
		
		if(studentResp==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			// return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(studentResp);	
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Student>> getAllStudennt(){
		List<Student> studentlist= studentService.getAllStudent();
		
		if(studentlist.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.ok(studentlist);	
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentReq ){
		Student studentResp= studentService.updateStudent(id,studentReq);
		
		if(studentResp==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			
		}
		return ResponseEntity.ok(studentResp);	
	}
	
	@DeleteMapping("/delete/{id}")
	public  ResponseEntity<String> deleteStudentByID(@PathVariable Long id) {
		Boolean isDeleted = studentService.deleteStudent(id);
	
		if(!isDeleted) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok("Record Deleted");
	}
	
	// Soft Delete 
//		@PatchMapping("/delete-soft/{id}")
//		public ResponseEntity<String> deleteStudentEntity(Long id){
//			Boolean isDeleted = studentService.deleteStudentSoftly(id);
//			
//			if(!isDeleted) {
//				return ResponseEntity.notFound().build();
//			}
//			return ResponseEntity.ok("Record Deleted");
//		}
		
	
	
	
}

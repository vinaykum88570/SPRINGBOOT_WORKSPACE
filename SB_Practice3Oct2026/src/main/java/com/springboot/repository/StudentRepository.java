package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer>{
	
	
	public Student getStudent(Integer id);

	@Query("select s FROM Student s")
	public List<Student> getAll();
	
	@Query("select s from Student s where s.name=:n")
	public List<Student> getStudentByName(@Param("n") String name);
	
	// Native Query
	@Query(value="select * from stu", nativeQuery = true)
	public List<Student> getAllStudent();
	
	
}
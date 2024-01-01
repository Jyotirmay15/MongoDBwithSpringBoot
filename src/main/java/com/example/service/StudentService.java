package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.entity.Student;
import com.example.repository.StudentRespository;

@Component
public class StudentService {

	@Autowired
	StudentRespository studentRespository;

	public Student createStudent(Student student) {
		return studentRespository.save(student);
	}

	public Student getStudentbyId(String id) {
		return studentRespository.findById(id).get();
	}

	public List<Student> getAllStudents() {
		return studentRespository.findAll();
	}

	public Student updateStudent(Student student) {
		return studentRespository.save(student);
	}

	public String deleteStudent(String id) {
		studentRespository.deleteById(id);
		return "Success";
	}
	
	public List<Student> getStudentsByName(String name) {
		return studentRespository.findByName(name);
	}
	
}

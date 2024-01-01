package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;
import com.example.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	@Autowired
	StudentService studentService;

	@PostMapping("/create")
	public Student createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}

	@GetMapping("/getById/{id}")
	public Student getStudentbyId(@PathVariable String id) {
		return studentService.getStudentbyId(id);
	}

	@GetMapping("/studentsByName/{name}")
	public List<Student> studentsByName(@PathVariable String name) {
		return studentService.getStudentsByName(name);
	}

	@GetMapping("/all")
	public List<Student> getAllStudent() {
		return studentService.getAllStudents();
	}

	@PutMapping("/update")
	public Student updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable String id) {
		return studentService.deleteStudent(id);
	}
}

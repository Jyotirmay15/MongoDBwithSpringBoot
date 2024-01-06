package com.example.service;

import com.example.entity.Student;
import com.example.repository.StudentRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentService {

    @Autowired
    StudentRespository studentRespository;

    public Student createStudent(Student student) {
        return studentRespository.save(student);
    }

    public Student getStudentbyId(String id) {
        if (studentRespository.findById(id).isPresent()) {
            return studentRespository.findById(id).get();
        } else {
            return null;
        }
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

    public List<Student> studentsByNameAndMail(String name, String email) {
        return studentRespository.findByNameAndEmail(name, email);
    }

    public List<Student> studentsByNameOrMail(String name, String email) {
        return studentRespository.findByNameOrEmail(name, email);
    }

    public List<Student> getAllWithPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

        return studentRespository.findAll(pageable).getContent();
    }

    public List<Student> allWithSorting() {
        Sort sort = Sort.by(Sort.Direction.ASC, "name");

        return studentRespository.findAll(sort);
    }

}

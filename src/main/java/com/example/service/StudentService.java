package com.example.service;

import com.example.entity.Student;
import com.example.repository.DepartmentRepository;
import com.example.repository.StudentRespository;
import com.example.repository.SubjectRepository;
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

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    SubjectRepository subjectRepository;

    public Student createStudent(Student student) {
        //When using references, we need to save the sub documents first before saving the main document
        if (student.getDepartment() != null) {
            departmentRepository.save(student.getDepartment());
        }
        if (student.getSubjects() != null && student.getSubjects().size() > 0) {
            subjectRepository.saveAll(student.getSubjects());
        }

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
        return studentRespository.getByName(name);
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

    public List<Student> byDepartmentName(String deptName) {
        return studentRespository.findByDepartmentDepartmentName(deptName);
    }

    public List<Student> bySubjectName(String subjectName) {
        return studentRespository.findBySubjectsSubjectName(subjectName);
    }

    public List<Student> emailLike(String email) {
        return studentRespository.findByEmailIsLike(email);
    }

    public List<Student> byDepartmentId(String deptId) {
        return studentRespository.findByDepartmentId(deptId);
    }
}

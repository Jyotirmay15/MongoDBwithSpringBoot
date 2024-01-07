package com.example.repository;

import com.example.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRespository extends MongoRepository<Student, String> {

    List<Student> findByName(String name);

    List<Student> findByNameAndEmail(String name, String email);

    List<Student> findByNameOrEmail(String name, String email);

    //This query will not work for references
    List<Student> findByDepartmentDepartmentName(String deptname);

    //This query will not work for references
    List<Student> findBySubjectsSubjectName(String subjectName);

    List<Student> findByEmailIsLike(String email);

    List<Student> findByDepartmentId (String deptId);

    //This annotation is used if you want to use native MongDb Queries
    @Query("{name: '?0'}")
    List<Student> getByName(String name);
}

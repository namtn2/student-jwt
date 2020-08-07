package com.example.namtn.demo.dao;

import com.example.namtn.demo.dto.ResultDTO;
import com.example.namtn.demo.model.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository {

    ResultDTO createOrUpdateStudent(Student student);

    ResultDTO findAllStudent();

    ResultDTO findStudentById(Long id);

    ResultDTO deleteStudent(Long id);
}

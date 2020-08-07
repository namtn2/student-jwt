package com.example.namtn.demo.service;

import com.example.namtn.demo.dto.ResultDTO;
import com.example.namtn.demo.model.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {

    ResultDTO createOrUpdateStudent(Student student);

    ResultDTO findAllStudent();

    ResultDTO findStudentById(Long id);

    ResultDTO deleteStudent(Long id);
}

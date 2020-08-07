package com.example.namtn.demo.service;

import com.example.namtn.demo.dao.StudentRepository;
import com.example.namtn.demo.dto.ResultDTO;
import com.example.namtn.demo.model.Student;
import com.example.namtn.demo.utils.StringUtils;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
@Log4j
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public ResultDTO createOrUpdateStudent(Student student) {
        return studentRepository.createOrUpdateStudent(student);
    }

    @Override
    public ResultDTO findAllStudent() {
        return studentRepository.findAllStudent();
    }

    @Override
    public ResultDTO findStudentById(Long id) {
        if (StringUtils.isLongNullOrZero(id)) {
            return new ResultDTO();
        }
        return studentRepository.findStudentById(id);
    }

    @Override
    public ResultDTO deleteStudent(Long id) {
        if (StringUtils.isLongNullOrZero(id)) {
            return new ResultDTO();
        }
        return studentRepository.deleteStudent(id);
    }
}

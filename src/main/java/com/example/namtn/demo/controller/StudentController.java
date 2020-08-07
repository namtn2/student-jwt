package com.example.namtn.demo.controller;

import com.example.namtn.demo.dto.ResultDTO;
import com.example.namtn.demo.model.Student;
import com.example.namtn.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Component
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    ResponseEntity<ResultDTO> create(@RequestBody Student student) {
        ResultDTO resultDTO = studentService.createOrUpdateStudent(student);
        return new ResponseEntity<>(resultDTO, HttpStatus.OK);
    }

    @PutMapping("/update")
    ResponseEntity<ResultDTO> update(@RequestBody Student student) {
        ResultDTO resultDTO = studentService.createOrUpdateStudent(student);
        return new ResponseEntity<>(resultDTO, HttpStatus.OK);
    }

    @GetMapping("/get")
    ResponseEntity<ResultDTO> get() {
        ResultDTO resultDTO = studentService.findAllStudent();
        return new ResponseEntity<>(resultDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    ResponseEntity<ResultDTO> getById(@PathVariable Long id) {
        ResultDTO resultDTO = studentService.findStudentById(id);
        return new ResponseEntity<>(resultDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<ResultDTO> deleteById(@PathVariable Long id) {
        ResultDTO resultDTO = studentService.deleteStudent(id);
        return new ResponseEntity<>(resultDTO, HttpStatus.OK);
    }
}

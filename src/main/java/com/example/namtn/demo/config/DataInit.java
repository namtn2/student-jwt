//package com.example.namtn.demo.config;
//
//import com.example.namtn.demo.dao.BaseRepository;
//import com.example.namtn.demo.model.Users;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class DataInit implements ApplicationRunner {
//
//    @Autowired
//    BaseRepository baseRepository;
//
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        Student student = new Student();
//        student.setStudentCode("S1");
//        student.setStudentName("Student 1");
//        student.setDateOfBirth(new Date());
//
//        studentRepository.createOrUpdateStudent(student);
//
//        student.setStudentCode("S2");
//        student.setStudentName("Student 2");
//
//        studentRepository.createOrUpdateStudent(student);
//
//        student.setStudentCode("S3");
//        student.setStudentName("Student 3");
//
//        studentRepository.createOrUpdateStudent(student);
//
//        Users users = new Users();
//        users.setUserName("namtn");
//        users.setFullName("Trần Nhật Nam");
//        users.setPassword("1");
//        users.setMobile("0823653939");
//        users.setEmail("namtn@itsol.vn");
//
//        baseRepository.save(users);
//    }
//}

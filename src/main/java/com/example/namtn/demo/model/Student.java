package com.example.namtn.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "STUDENT")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Column(name = "ID")
    @Id
//    @GeneratedValue
    private Long id;

    @Column(name = "STUDENT_CODE")
    private String studentCode;

    @Column(name = "STUDENT_NAME")
    private String studentName;

    @Column(name = "DATE_OF_BIRTH")
    private Date dateOfBirth;

}

package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/student")
public class StudentController {

    private static List<Student> students= Arrays.asList(
            new Student(1,"jams bond"),
            new Student(2,"Maria jane"),
            new Student(3,"issam shimi")
    );

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable Integer studentId){
    return students.stream()
            .filter(x->studentId.equals(x.getStudentId()))
            .findFirst()
            .orElseThrow(() ->new IllegalStateException("Student "+studentId+" doesn  exist"));
    }
}

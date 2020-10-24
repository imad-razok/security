package com.example.demo.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/management/api/v1/student")
public class StudentManagementController {
    private static List<Student> students= Arrays.asList(
            new Student(1,"jams bond"),
            new Student(2,"Maria jane"),
            new Student(3,"issam shimi")
    );
    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ADMINTRAINEE')")
    public List<Student> getAll(){
        return students;
    }
    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void register(@RequestBody Student student){
        System.out.println(student);
    }
    @DeleteMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void deleteStudent(@PathVariable Integer studentId){
        System.out.println(studentId);
    }

    @PutMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void updateStudent(@PathVariable Integer studentId,@RequestBody Student student){
        System.out.println(studentId +" "+student);
    }
}

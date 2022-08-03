package com.example.demo.students;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudensManagementController {
    private static final List<Student> students = Arrays.asList(
            new Student(1, "Anas"),
            new Student(2, "Ahmad"),
            new Student(3, "Jamal")
    );

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN' , 'ROLE_ADMINTRAINEE')")
    public List<Student> getAllStudents() {
        System.out.println("Get All Students");
        return students;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void registerNewStudent(@RequestBody Student student) {
        System.out.println("registerNewStudent");
        System.out.println(student);
    }

    @DeleteMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void deleteAStudent(@PathVariable("studentId") Integer studentId) {
        System.out.println("deleteAStudent");
        System.out.println(studentId);
    }

    @PutMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void updateStudent(@PathVariable("studentId") Integer studentId, @RequestBody Student student) {
        System.out.println("updateStudent");
        System.out.println(student);
    }
}

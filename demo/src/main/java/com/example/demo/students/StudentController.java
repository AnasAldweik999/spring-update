package com.example.demo.students;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {


    private static final List<Student> students = Arrays.asList(
            new Student(1, "Anas"),
            new Student(2, "Ahmad"),
            new Student(3, "Jamal")
    );

    @GetMapping(path = "{studentId}")
    private Student getStudent(@PathVariable("studentId") Integer studentId) {

        return students.stream().filter(student -> studentId.equals(student.getStudentId())).findFirst()
                .orElseThrow(() -> new IllegalStateException("Student Id " + studentId + " Not Found"));
    }
}

package com.example.demo.students;

public class Student {

    private final Integer studentId;
    private final String name;

    public Student(Integer studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public Integer getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                '}';
    }
}

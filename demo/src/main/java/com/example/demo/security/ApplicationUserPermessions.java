package com.example.demo.security;

public enum ApplicationUserPermessions {
    STUDENT_READ("student:read"),
    STUDENT_WRITE("student:write"),
    COURSE_WRITE("course:write"),
    COURSE_READ("course:read");

    public final String persmession;

    ApplicationUserPermessions(String permession) {
        this.persmession = permession;
    }

    public String getPersmession() {
        return persmession;
    }
}

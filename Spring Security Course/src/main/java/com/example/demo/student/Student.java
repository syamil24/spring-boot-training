package com.example.demo.student;

public class Student {

    private final Integer studentId;
    private final String studentName;

    public Integer getStudentId() {
        return this.studentId;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public Student(Integer studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "{" +
                " studentId='" + getStudentId() + "'" +
                ", studentName='" + getStudentName() + "'" +
                "}";
    }

}

package com.coursemanagement;

public class StudentData {
    private String course;
    private String studentName;
    private String studentMail;  // New field for student email

    public StudentData(String course, String studentName, String studentMail) {
        this.course = course;
        this.studentName = studentName;
        this.studentMail = studentMail;
    }

    public String getStudentCourse() {
        return course;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentMail() {
        return studentMail;
    }
}

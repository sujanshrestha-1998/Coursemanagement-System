package com.coursemanagement;

public class Teacher {
    private String name;
    private String email;
    private String password;
    private String contactNo;
    private String course;
    private String module;

    public Teacher(String name, String email, String password, String contactNo, String course, String module) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.contactNo = contactNo;
        this.course = course;
        this.module = module;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getCourse() {
        return course;
    }

    public String getModule() {
        return module;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setModule(String module) {
        this.module = module;
    }
}

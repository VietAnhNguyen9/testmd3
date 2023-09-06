package com.example.kiemtra.model;

import java.time.LocalDate;

public class Student {
    private int idStudent;
    private String name;
    private LocalDate dob;
    private String email;
    private String address;
    private String phone;
    private Classroom classroom;

    public Student() {
    }

    public Student(int idStudent, String name, LocalDate dob, String email, String address, String phone, Classroom classroom) {
        this.idStudent = idStudent;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.classroom = classroom;
    }

    public Student(String name, LocalDate dob, String email, String address, String phone, Classroom classroom) {
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.classroom = classroom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }
}

package com.example.kiemtra.service;

import com.example.kiemtra.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Student findOne(int id);
    void createStudent(Student student);
    void updateStudent(Student student);
    void delete(int id);
    List<Student> search(String name);
}

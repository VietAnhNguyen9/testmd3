package com.example.kiemtra.service.impl;

import com.example.kiemtra.DAO.StudentDAO;
import com.example.kiemtra.model.Student;

import java.sql.Connection;
import java.util.List;

public class StudentService implements com.example.kiemtra.service.StudentService {

    StudentDAO studentDAO = new StudentDAO();
    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public Student findOne(int id) {
        return studentDAO.findOne(id);
    }

    @Override
    public void createStudent(Student student) {
        studentDAO.create(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentDAO.update(student);
    }

    @Override
    public void delete(int id) {
        studentDAO.delete(id);
    }

    @Override
    public List<Student> search(String name) {
        return null;
    }
}

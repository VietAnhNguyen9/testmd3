package com.example.kiemtra.service;

import com.example.kiemtra.model.Classroom;
import com.example.kiemtra.model.Student;

import java.util.List;

public interface ClassRoom {
    List<Classroom> findAll();
    ClassRoom findOne(int id);
}

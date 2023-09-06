package com.example.kiemtra.service.impl;

import com.example.kiemtra.DAO.ClassDAO;
import com.example.kiemtra.model.Classroom;
import com.example.kiemtra.service.ClassRoom;

import java.sql.Connection;
import java.util.List;

public class ClassRoomService implements com.example.kiemtra.service.ClassRoom {
    Connection connection;
    ClassDAO classDAO = new ClassDAO();

    @Override
    public List<Classroom> findAll() {
        return classDAO.findAll();
    }

    @Override
    public ClassRoom findOne(int id) {
        return (ClassRoom) classDAO.findOne(id);
    }
}

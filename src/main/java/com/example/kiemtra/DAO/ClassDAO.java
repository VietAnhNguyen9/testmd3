package com.example.kiemtra.DAO;

import com.example.kiemtra.connection.MyConnection;
import com.example.kiemtra.model.Classroom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClassDAO {
   Connection connection;
   MyConnection myConnection = new MyConnection();



    public ClassDAO() {
        connection = myConnection.getConnection();
    }

    private final String SELECT_ALL = "select * from classroom;";
    private final String SELECT_BY_ID = "select * from classroom where idClass = ?;";

    public List<Classroom> findAll() {
        List<Classroom> listClass = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idClass = resultSet.getInt("idClass");
                String nameClass = resultSet.getString("nameClass");
                listClass.add(new Classroom(idClass,nameClass));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listClass;
    }

    public Classroom findOne(int id) {
        Classroom classroom = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idClass = resultSet.getInt("idClass");
                String nameClass = resultSet.getString("nameClass");
                classroom = new Classroom(idClass, nameClass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classroom;
    }
}
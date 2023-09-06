package com.example.kiemtra.DAO;

import com.example.kiemtra.connection.MyConnection;
import com.example.kiemtra.model.Classroom;
import com.example.kiemtra.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    MyConnection myConnection = new MyConnection();
    Connection connection;
    ClassDAO classDAO ;

    public StudentDAO() {
        connection = myConnection.getConnection();
        classDAO = new ClassDAO();
    }

    private final String SELECT_ALL = "select * from student;";
    private final String SELECT_BY_ID = "select * from student where id = ?;";
    private final String INSERT_INTO = "insert into student(name, dob, email, address, phone, idClass) value (?,?,?,?,?,?);";
    private final String UPDATE_BY_ID = "update student set name = ?,dob = ?,email = ?, address = ?, phone = ?, idClass = ? where id = ?;";
    private final String DELETE_BY_ID = "delete from student where id = ?;";
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                LocalDate dob = resultSet.getObject("dob", LocalDate.class);
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                int idClass = resultSet.getInt("idClass");
                Classroom classroom = classDAO.findOne(idClass);
                students.add(new Student(id, name, dob, email, address, phone, classroom));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public Student findOne(int id) {
        Student student = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idStudent = resultSet.getInt("id");
                String name = resultSet.getString("name");
                LocalDate dob = resultSet.getObject("dob", LocalDate.class);
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                int idClass = resultSet.getInt("idClass");
                Classroom classroom = classDAO.findOne(idClass);
                student = new Student(idStudent, name, dob, email, address, phone,classroom);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public void create(Student student) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getDob().toString());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setString(4, student.getAddress());
            preparedStatement.setString(5, student.getPhone());
            preparedStatement.setInt(6, student.getClassroom().getIdClass());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Student student) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2,student.getDob().toString());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setString(4, student.getAddress());
            preparedStatement.setString(5, student.getPhone());
            preparedStatement.setInt(6, student.getClassroom().getIdClass());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

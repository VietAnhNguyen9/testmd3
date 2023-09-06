package com.example.kiemtra.controller;

import com.example.kiemtra.DAO.ClassDAO;
import com.example.kiemtra.model.Classroom;
import com.example.kiemtra.model.Student;
import com.example.kiemtra.service.impl.ClassRoomService;
import com.example.kiemtra.service.impl.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/student")
public class StudentServlet extends HttpServlet {

    StudentService studentService = new StudentService();
    ClassRoomService classRoomService = new ClassRoomService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "":
                display(request,response);
                break;
            case "create":
                createGet(request,response);
                break;
            case "delete":
                delete(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createPost(request,response);
                break;
        }
    }
    public void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> listStudent = new ArrayList<>();
        listStudent = studentService.findAll();
        request.setAttribute("listStudent", listStudent);
        request.getRequestDispatcher("home.jsp").forward(request,response);
    }

    public void createGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("home.jsp").forward(request,response);
    }
    public void createPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        LocalDate dob = LocalDate.parse(request.getParameter("dob"));
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        int idClass = Integer.parseInt(request.getParameter("idClass"));
        Classroom classroom = (Classroom) classRoomService.findOne(idClass);
        Student student = new Student(name, dob, email,address, phone, classroom);
        studentService.createStudent(student);
        response.sendRedirect("/student");
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        studentService.delete(id);
        response.sendRedirect("/student");

    }

//   public Student updateGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.sendRedirect("update.jsp");
//   }
//   public  Student updatePost(HttpServletRequest request, HttpServletResponse response) {
//
//   }


}
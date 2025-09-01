package com.vcube.controller;

import java.io.IOException;

import com.vcube.DAO.StudentDAO;
import com.vcube.model.StudentModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ViewController")
public class View extends HttpServlet {
    private static final long serialVersionUID = 1L;
    // This method handles GET requests
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int studentId = Integer.parseInt(request.getParameter("Studentid"));
        System.out.println("Fetching student with ID: " + studentId);
        
        // Call the DAO method to fetch the student by ID
        StudentDAO studentDAO = new StudentDAO();
        StudentModel student = studentDAO.UpdateStudentById(studentId);
        
        // Check if student exists
        if (student != null) {
            System.out.println(student);
            request.setAttribute("students", student);
            RequestDispatcher rd = request.getRequestDispatcher("UpdateStudent.jsp");
            rd.forward(request, response);
        } else {
            // If student not found, redirect to error page or handle accordingly
            response.sendRedirect("errorPage.jsp");
        }
    }

    // This method handles POST requests (for submitting updates)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Collect updated student information
        int studentId = Integer.parseInt(request.getParameter("Studentid"));
        String username = request.getParameter("username");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String password = request.getParameter("password");
        
        // Create a StudentModel object with the updated data
        StudentModel student = new StudentModel();
        student.setStudentid(studentId);
        student.setUsername(username);
        student.setFirstname(firstname);
        student.setLastname(lastname);
        student.setPassword(password);       
        // Call the DAO method to update the student details
        StudentDAO studentDAO = new StudentDAO();
        String status = studentDAO.updateStudent(student);
        System.out.println("Update status: " + status);       
        // Get the session to update the student data in session if needed
        HttpSession session = request.getSession();
        StudentModel sessionStudent = (StudentModel) session.getAttribute("st");
        if (sessionStudent != null && sessionStudent.getStudentid() == student.getStudentid()) {
            // Update session student details if the logged-in user is updating their own profile
            sessionStudent.setStudentid(student.getStudentid());
            sessionStudent.setUsername(student.getUsername());
            sessionStudent.setFirstname(student.getFirstname());
            sessionStudent.setLastname(student.getLastname());
            sessionStudent.setPassword(student.getPassword());
            System.out.println("Updated student details in session...");
            RequestDispatcher rd = request.getRequestDispatcher("view.jsp");
            rd.forward(request, response);
        } else if ("success".equals(status)) {
            // Redirect to the student list page if the update was successful
            response.sendRedirect("ListOfStudent");
        } else {
            // Handle failure in update (e.g., show error message on the update page)
            request.setAttribute("error", "Update failed. Please try again.");
            RequestDispatcher rd = request.getRequestDispatcher("UpdateStudent.jsp");
            rd.forward(request, response);
        }
    }
}

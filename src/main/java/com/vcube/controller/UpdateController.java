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
@WebServlet("/UpdateStudentServlet")
public class UpdateController extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch the student by ID for displaying in the update form
        int studentId = Integer.parseInt(request.getParameter("id"));
        System.out.println(studentId);
        StudentDAO a = new StudentDAO();
        StudentModel s = a.UpdateStudentById(studentId); // Fetch student details
        System.out.println(s);
        request.setAttribute("students", s); // Pass student object to JSP
        RequestDispatcher r1 = request.getRequestDispatcher("UpdateStud.jsp");
        r1.forward(request, response);
    }
    @Override    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Collect updated student information
        int studentId = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String password = request.getParameter("password");
        StudentDAO a = new StudentDAO();
        StudentModel s = new StudentModel();
        s.setStudentid(studentId);
        s.setUsername(username);
        s.setFirstname(firstname);
        s.setLastname(lastname);
        s.setPassword(password);
        // Call updateStudent to update the student details
        String status = a.updateStudent(s); // Call the updateStudent method for updating
        System.out.println(status);
        // If the session student is the same as the updated one, update the session
        HttpSession h = request.getSession();
        StudentModel session = (StudentModel) h.getAttribute("st");
        System.out.println(session);
        if (session != null && session.getStudentid() == s.getStudentid()) {
            // Update session details with the new student data
            session.setStudentid(s.getStudentid());
            session.setUsername(s.getUsername());
            session.setFirstname(s.getFirstname());
            session.setLastname(s.getLastname());
            session.setPassword(s.getPassword());
            System.out.println("Updated student details are...");
            RequestDispatcher r1 = request.getRequestDispatcher("view.jsp"); // After successful update, forward to view.jsp
            r1.forward(request, response);
        } else if (status.equals("success")) {
            // If update is successful, redirect to the student list page
            response.sendRedirect("ViewServlet");
        } else {
            // If update fails, show the update page with an error message
            request.setAttribute("error", "Update failed!");
            RequestDispatcher r1 = request.getRequestDispatcher("UpdateStud.jsp");
            r1.forward(request, response);
        }
    }
}

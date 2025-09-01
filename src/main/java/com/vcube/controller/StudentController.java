package com.vcube.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.vcube.DAO.StudentDAO;
import com.vcube.model.StudentModel;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/register")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentController() {
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hello");
		// TODO Auto-generated method stub
		int studentid=Integer.parseInt(request.getParameter("studentid"));
		String username = request.getParameter("username");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String password = request.getParameter("password");
		//String Reenterpassword = request.getParameter("Reenterpassword");
		System.out.println(firstname);
		StudentModel sm = new StudentModel();
		sm.setStudentid(studentid);
		sm.setUsername(username);
		sm.setFirstname(firstname);
		sm.setLastname(lastname);
		sm.setPassword(password);
		//sm.setFirstname(Reenterpassword);
		
		System.out.println("model data: " + sm);
		StudentDAO sd = new StudentDAO();
		String status = sd.insertStudent(sm);
		System.out.println(status);
		if (status.equals("SUCCESS")) {
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);

		}

	}

}

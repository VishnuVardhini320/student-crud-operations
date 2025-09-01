package com.vcube.controller;

import java.io.IOException;

import com.vcube.DAO.StudentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class Delete extends HttpServlet {
	// private static final long serialVersionUID = 1L;
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		int studentid = Integer.parseInt(request.getParameter("id"));
		System.out.println("---------");
		System.out.println(studentid);
		StudentDAO r = new StudentDAO();
		String status = r.DeleteStudentByid(studentid);
		if (status.equals("success")) {
			response.sendRedirect("ViewServlet");
		}
	}

}

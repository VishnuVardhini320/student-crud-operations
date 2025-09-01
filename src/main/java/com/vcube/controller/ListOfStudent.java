package com.vcube.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vcube.DAO.StudentDAO;
import com.vcube.model.StudentModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ViewServlet")
public class ListOfStudent extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        StudentDAO dao = new StudentDAO();

        try {
            List<StudentModel> all = dao.getAllStudents();
            request.setAttribute("all", all);

            RequestDispatcher rd = request.getRequestDispatcher("View.jsp");
            rd.forward(request, response);  // ✅ Forwarding the request here
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error fetching student list: " + e.getMessage());
        }
    }

    // Optional: handle GET requests the same way
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);  // ✅ To support both GET and POST
    }
}

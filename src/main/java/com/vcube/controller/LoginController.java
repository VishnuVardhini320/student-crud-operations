package com.vcube.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.vcube.DAO.StudentDAO;
import com.vcube.model.LoginDTO;
import com.vcube.model.StudentModel;
@WebServlet("/Login")
public class LoginController extends HttpServlet {
	//private static final long serialVersionUID = 1L;
       protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	   String username=request.getParameter("username");
    	   String password=request.getParameter("password");
    	   System.out.println(username + ":"+ password);
    	   LoginDTO l=new LoginDTO();
    	   l.setUsername(username);
    	   l.setPassword(password);
    	   StudentDAO sd=new StudentDAO();
    	   StudentModel sm = sd.selectStudent(l);
    	   HttpSession ss=request.getSession();
    	   if(sm !=null) {
//    		   request.setAttribute("obj", sm);
    		   ss.setAttribute("obj",sm);
    		   RequestDispatcher rd=request.getRequestDispatcher("/home.jsp");
    		   rd.forward(request, response);
    	   }
    	   else {
    		   String error="something went wrong";
    		   request.setAttribute("error",error);
    		   RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
    		   rd.forward(request, response);  		   
    	   }
    	   
    	   
	}

}

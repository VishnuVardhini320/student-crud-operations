<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.vcube.model.StudentModel" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <% 
    	HttpSession ss=request.getSession(false);
    	StudentModel sm=(StudentModel) ss.getAttribute("obj");
    
    %>
    <title>Welcome <%=sm.getFirstname() %>></title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(to right, #d3cce3, #e9e4f0);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            color: #2c3e50;
        }

        .welcome-box {
            background-color: rgba(255, 255, 255, 0.95);
            padding: 40px 50px;
            border-radius: 15px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.15);
            text-align: center;
            max-width: 400px;
        }

        h1 {
            font-size: 32px;
            margin-bottom: 15px;
            color: #6a1b9a;
        }

        p {
            font-size: 18px;
            color: #444;
        }

        .username {
            color: #8e24aa;
            font-weight: bold;
        }

        a.button {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #6a1b9a;
            color: #fff;
            border-radius: 8px;
            text-decoration: none;
            font-weight: bold;
            transition: background-color 0.3s ease;
        }

        a.button:hover {
            background-color: #4a0072;
        }
         a.button {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #6a1b9a;
            color: #fff;
            border-radius: 8px;
            text-decoration: none;
            font-weight: bold;
            transition: background-color 0.3s ease;
        }

        a.button:hover {
            background-color: #4a0072;
        }
    </style>
</head>
<body>
    <div class="welcome-box">
        <h1>Welcome!</h1>
        <p>Hello, <span class="username"><%= request.getAttribute("un") %></span>. You have successfully logged in.</p>
         <a href="ViewServlet"><button type="submit">viewStudents</button></a>
        <a href="login.jsp" class="button">Logout</a>
    </div>
</body>
</html>

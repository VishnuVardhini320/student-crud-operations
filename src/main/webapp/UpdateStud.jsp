<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Student</title>
    
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: #f4f4f9;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 450px;
            margin: 60px auto;
            background: #ffffff;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 25px;
        }

        form {
            display: flex;
            flex-direction: column;
        }

        label {
            margin-bottom: 5px;
            font-weight: bold;
            color: #555;
        }

        input[type="text"],
        input[type="password"] {
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 8px;
            font-size: 15px;
        }

        input[type="submit"] {
            padding: 12px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        .back-link {
            display: block;
            text-align: center;
            margin-top: 20px;
            color: #007BFF;
            text-decoration: none;
            font-weight: bold;
        }

        .back-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Update Student Details</h1>   

        <form action="UpdateStudentServlet" method="post">
            <input type="hidden" name="id" value="${students.studentid}" />
            
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" value="${students.username}" required />
            
            <label for="firstname">First Name:</label>
            <input type="text" id="firstname" name="firstname" value="${students.firstname}" required />
            
            <label for="lastname">Last Name:</label>
            <input type="text" id="lastname" name="lastname" value="${students.lastname}" required />
            
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" value="${students.password}" required />
            
            <input type="submit" value="Update" />
        </form>

        <a href="ListOfStudent" class="back-link">← Back to Student List</a>
    </div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(to right, #bdc3c7, #2c3e50);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .login-box {
            background-color: rgba(255, 255, 255, 0.95);
            padding: 35px 40px;
            border-radius: 15px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.2);
            width: 350px;
        }

        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 30px;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 12px;
            margin: 10px 0 20px;
            border: 1px solid #ccc;
            border-radius: 8px;
            font-size: 14px;
        }

        button {
            width: 100%;
            padding: 12px;
            background: #3498db;
            color: white;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
            transition: 0.3s ease;
        }

        button:hover {
            background: #2980b9;
        }

        .error {
            color: #e74c3c;
            background-color: #fdecea;
            padding: 10px;
            text-align: center;
            border-radius: 6px;
            margin-top: 10px;
            font-size: 14px;
        }

        ::placeholder {
            color: #aaa;
        }
    </style>
</head>
<body>
    <div class="login-box">
        <h1>Login</h1>
        <form name="LoginPage" method="post" action="Login">
            <input type="text" name="username" id="username" placeholder="Username" required>
            <input type="password" name="password" id="password" placeholder="Password" required>

            <% if (request.getAttribute("error") != null) { %>
                <div class="error"><%= request.getAttribute("error") %></div>
            <% } %>

            <button type="submit">Login</button>
        </form>
    </div>
</body>
</html>

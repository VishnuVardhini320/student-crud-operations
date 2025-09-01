<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Registration</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(to right, #83a4d4, #b6fbff);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .container {
            background-color: rgba(255, 255, 255, 0.95);
            padding: 30px 40px;
            border-radius: 15px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.2);
            width: 400px;
        }

        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 25px;
        }

        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 12px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 8px;
            font-size: 14px;
        }

        button {
            width: 100%;
            padding: 12px;
            background-color: #28a745;
            color: white;
            border: none;
            font-size: 16px;
            font-weight: bold;
            border-radius: 8px;
            cursor: pointer;
            margin-top: 15px;
        }

        button:hover {
            background-color: #218838;
        }

        ::placeholder {
            color: #aaa;
        }

        .error {
            color: red;
            font-size: 13px;
            margin-top: -5px;
            margin-bottom: 10px;
        }
    </style>

    <script>
        function validateForm() {
        	let studentid = document.getElementById("studentid").value.trim();
            let username = document.getElementById("username").value.trim();
            let firstname = document.getElementById("firstname").value.trim();
            let lastname = document.getElementById("lastname").value.trim();
            let password = document.getElementById("password").value.trim();
            let reenterpassword = document.getElementById("reenterpassword").value.trim();

            // Remove previous error messages
            document.querySelectorAll(".error").forEach(e => e.remove());

            let isValid = true;

            // First Name: alphabets only
            if (!/^\d+$/.test(studentid)) {
    			showError("studentid", "Student ID must contain numbers only.");
    			isValid = false;
}
            if (!/^[A-Za-z]+$/.test(firstname)) {
                showError("firstname", "First name must contain only alphabets.");
                isValid = false;
            }

            // Last Name: alphabets only
            if (!/^[A-Za-z]+$/.test(lastname)) {
                showError("lastname", "Last name must contain only alphabets.");
                isValid = false;
            }

            // Password: minimum 6 characters
            if (password.length < 6) {
                showError("password", "Password must be at least 6 characters.");
                isValid = false;
            }

            // Re-enter Password: must match
            if (reenterpassword !== password) {
                showError("reenterpassword", "Passwords do not match.");
                isValid = false;
            }

            return isValid;
        }

        function showError(id, message) {
            const input = document.getElementById(id);
            const error = document.createElement("div");
            error.className = "error";
            error.textContent = message;
            input.parentNode.insertBefore(error, input.nextSibling);
        }
    </script>
</head>
<body>
    <div class="container">
        <h1>Welcome to Registration</h1>
        <form name="registrationPage" method="post" action="register" onsubmit="return validateForm()">
        	<input type="text" name="studentid" id="studentid" placeholder="studentid"> 
            <input type="text" name="username" id="username" placeholder="User Name">
            <input type="text" name="firstname" id="firstname" placeholder="First Name">
            <input type="text" name="lastname" id="lastname" placeholder="Last Name">
            <input type="password" name="password" id="password" placeholder="Password">
            <input type="password" name="reenterpassword" id="reenterpassword" placeholder="Re-enter Password">
            <button type="submit">Register</button>
            <a href="login.jsp">Already have account login here</a>
        </form>
	</div>
</body>
</html>


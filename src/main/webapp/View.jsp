<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.vcube.model.StudentModel"%>
<%@ page import="java.util.List" %>

<html>
<head>
<title>Student List</title>
<style>
body {
	font-family: Arial, sans-serif;
	background: #f4f6f9;
	margin: 0;
	padding: 20px;
}

h2 {
	text-align: center;
	color: #333;
}

table {
	width: 90%;
	margin: 0 auto;
	border-collapse: collapse;
	background-color: #fff;
	box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
}

th, td {
	padding: 12px 16px;
	border-bottom: 1px solid #ddd;
	text-align: center;
}

th {
	background-color: #007bff;
	color: white;
}

tr:hover {
	background-color: #f1f1f1;
}

.btn {
	padding: 6px 12px;
	border: none;
	border-radius: 4px;
	color: white;
	cursor: pointer;
}

.update-btn {
	background-color: #28a745;
}

.delete-btn {
	background-color: #dc3545;
}

.btn:hover {
	opacity: 0.9;
}
</style>
</head>
<body>

	<h2>Student List</h2>

	<table>
		<tr>
			<th>ID</th>
			<th>Username</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Password</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>

		<%
        List<StudentModel> studentList = (List<StudentModel>) request.getAttribute("all");
        if (studentList != null) {
            for (StudentModel student : studentList) {
    %>
		<tr>
			<td><%= student.getStudentid() %></td>
			<td><%= student.getUsername() %></td>
			<td><%= student.getFirstname() %></td>
			<td><%= student.getLastname() %></td>
			<td><%= student.getPassword() %></td>
			<td>
<!-- 				<form action="UpdateStudentServlet" method="post" style="margin: 0;"> -->
<%-- 					<input type="hidden" name="id" value="<%= student.getStudentid() %>" /> --%>
<!-- 					<button type="submit" class="btn update-btn">Update</button> -->
<!-- 				</form> -->
				<a href="UpdateStudentServlet?id=<%= student.getStudentid() %>"><button type="submit" class="btn update-btn">Update</button></a>
			</td>
			<td>
<!-- 				<form action="DeleteStudentServlet" method="post" style="margin: 0;"> -->
<%-- 					<input type="hidden" name="id" value="<%= student.getStudentid() %>" /> --%>
<!-- 					<button type="submit" class="btn delete-btn">Delete</button> -->
<!-- 				</form> -->
	<a href="delete?id=<%= student.getStudentid() %>"><button type="submit" class="btn update-btn">Delete</button></a>
			</td>
		</tr>
		<%
            }
        } else {
    %>
		<tr>
			<td colspan="7">No student data available.</td>
		</tr>
		<%
        }
    %>
	</table>

</body>
</html>

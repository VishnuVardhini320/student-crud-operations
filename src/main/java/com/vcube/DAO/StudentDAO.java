package com.vcube.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vcube.model.LoginDTO;
import com.vcube.model.StudentModel;
import com.vcube.utility.DBConnection;
public class StudentDAO implements StudentDAOInterface {
	String status="fail";
	Connection con;
	public String insertStudent(StudentModel sm) {
		try {
			DBConnection dbc=new DBConnection();
			con=dbc.getConnection();
			System.out.println("Dao data: "+sm.getFirstname());
			PreparedStatement ps=con.prepareStatement("insert into students(studentid,username,firstname,lastname,password) values(?,?,?,?,?)");
			ps.setInt(1, sm.getStudentid());
			ps.setString(2, sm.getUsername());
			ps.setString(3, sm.getFirstname());
			ps.setString(4, sm.getLastname());
			ps.setString(5, sm.getPassword());
			int n=ps.executeUpdate();
			if(n>0) {
				System.out.println(n + "row inserted successfully");
				status="SUCCESS";
			}
			else {
				System.out.println("sorry!! something went wrong");
			}			
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
		
		
	}
	@Override
	public StudentModel selectStudent(LoginDTO l) {
		StudentModel sm=null;
		try {
			DBConnection dbc=new DBConnection();
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch5051","root","root");
			PreparedStatement ps=con.prepareStatement("select * from students where username=? and password=?");
			ps.setString(1, l.getUsername());
			ps.setString(2, l.getPassword());
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				 sm=new StudentModel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			}
//			int c=0;
//			while(rs.next()) {
//				c++;
//			}
//			if(c>0) {
//				status="SUCCESS";
//			}			
		}
		catch(Exception e) {
			
		}
		// TODO Auto-generated method stub
		return sm;
	}
	public List<StudentModel> getAllStudents() throws SQLException{
		List<StudentModel>l =new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch5051","root","root");
			PreparedStatement ps=con.prepareStatement("select * from students ");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				StudentModel s=new StudentModel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			    l.add(s);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return l;
	}
	// Fetch student by ID (existing method)
	public StudentModel UpdateStudentById(int studentId) {
	    StudentModel student = null;
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch5051", "root", "root");
	        PreparedStatement ps = con.prepareStatement("SELECT * FROM students WHERE studentid = ?");
	        ps.setInt(1, studentId);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            student = new StudentModel(
	                rs.getInt("studentid"),
	                rs.getString("username"),
	                rs.getString("firstname"),
	                rs.getString("lastname"),
	                rs.getString("password")
	            );
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return student;
	}

	// Update student details
	public String updateStudent(StudentModel sm) {
	    String status = "fail";
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch5051", "root", "root");
	        PreparedStatement ps = con.prepareStatement("UPDATE students SET username = ?, firstname = ?, lastname = ?, password = ? WHERE studentid = ?");
	        ps.setString(1, sm.getUsername());
	        ps.setString(2, sm.getFirstname());
	        ps.setString(3, sm.getLastname());
	        ps.setString(4, sm.getPassword());
	        ps.setInt(5, sm.getStudentid());

	        int result = ps.executeUpdate();
	        if (result > 0) {
	            status = "success"; // Set status to success if the update is successful
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return status;
	}
	public String DeleteStudentByid(int id) {
		String status = "fail";
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch5051", "root", "root");
	        PreparedStatement ps = con.prepareStatement("DELETE From Students where studentid=?");
	        ps.setInt(1, id);
	        int result = ps.executeUpdate();
	        if(result>0) {
	        	status="success";
	        }		
	}
	    catch(Exception e) {
	    	System.out.println(e.getLocalizedMessage());
	    }
	    return status;
	}
}
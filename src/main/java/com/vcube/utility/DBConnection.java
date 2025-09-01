package com.vcube.utility;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection {
	Connection con=null;
	public Connection getConnection() {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch5051","root","root");
		}
		catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		return con;
	}

}

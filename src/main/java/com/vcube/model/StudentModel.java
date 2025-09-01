package com.vcube.model;

public class StudentModel {
private int studentid; 
private String username;
private String firstname;
private String lastname;
private String password;
public StudentModel() {}
public StudentModel(int sid,String un, String fn, String ln, String pwd) {
	this.username=un;
	this.firstname=fn;
	this.lastname=ln;
	this.password=pwd;
	this.studentid=sid;
}

public int getStudentid() {
	return studentid;
}
public void setStudentid(int studentid) {
	this.studentid = studentid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String toString() {
	return username + firstname + lastname + password + studentid;
}


}

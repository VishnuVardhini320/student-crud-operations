package com.vcube.DAO;

import com.vcube.model.LoginDTO;
import com.vcube.model.StudentModel;

public interface StudentDAOInterface {
	public String insertStudent(StudentModel sm);
	public StudentModel selectStudent(LoginDTO l);

}

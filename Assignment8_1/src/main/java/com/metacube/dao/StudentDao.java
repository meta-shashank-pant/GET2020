package com.metacube.dao;

import java.util.List;

import com.metacube.models.Student;

public interface StudentDao {

	/**
	 * 
	 * @param employeeCommands
	 * @return
	 */
	int addStudent(Student student);

	/**
	 * 
	 * @param id
	 * @return
	 */
	Student getStudent(int id);

	/**
	 * 
	 * @param employeeCommands
	 * @return
	 */
	boolean updateStudent(Student student);
	
	/**
	 * 
	 * @return
	 */
	public List<Student> getAllStudent();
	
}

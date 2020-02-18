package com.metacube.service;

import java.util.List;

import com.metacube.models.Student;

public interface StudentService {

	int addStudent(Student student);


	/**
	 * 
	 * @param id
	 * @return
	 */
	Student getStudent(int id);


	/**
	 * 
	 * @param Student
	 * @return
	 */
	boolean updateStudent(Student student);


	/**
	 * 
	 * @return
	 */
	List<Student> getAllStudent();
}

package com.metacube.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.metacube.models.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	static List<Student> students = new ArrayList<Student>();

	static int counter = 1;
	
	@Override
	public int addStudent(Student student) {
		// TODO Auto-generated method stub
		student.setId(counter);
		students.add(student);
		counter++;
		return 0;
	}

	@Override
	public Student getStudent(int id) {
		Student student = null;

		for (Student stud : students) {
			if (stud.getId() == id) {
				student = stud;
				break;
			}

		}

		return student;
	}

	@Override
	public boolean updateStudent(Student student) {
		Student oldStudent = getStudent(student.getId());
		int index =  students.indexOf(oldStudent);
		students.remove(index);
		students.add(student); 
		return true;
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return students;
	}

}

package com.metacube.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.dao.StudentDao;
import com.metacube.models.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao studentDao;

	@Override
	public int addStudent(Student student) {
		// TODO Auto-generated method stub
		studentDao.addStudent(student);
		return 0;
	}

	@Override
	public Student getStudent(int id) {
		// TODO Auto-generated method stub
		return studentDao.getStudent(id);
	}

	@Override
	public boolean updateStudent(Student student) {
		// TODO Auto-generated method stub
		return studentDao.updateStudent(student);
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentDao.getAllStudent();
	}

}

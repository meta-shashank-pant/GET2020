package com.metacube.EAD_Session_14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.EAD_Session_14.model.Student;
import com.metacube.EAD_Session_14.repository.StudentRepo;

@Service
public class ServiceClass {
	
	@Autowired
	private StudentRepo repo;
	
	
   	public void add(Student student) {
		repo.save(student);
    	}
	

    	public List<Student> findAll() {
        	return repo.findAll();
    	}
	

    	public List<Student> findByNameIs(String name) {
        	return repo.findByNameIs(name);
    	}

    	public List<Student> findByfirstNameContainingIgnoreCase(String searchString) {
        	return repo.findByfirstNameContainingIgnoreCase(searchString);
    	}
}

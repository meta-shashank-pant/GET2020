package com.metacube.EAD_Session_13.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.EAD_Session_13.model.Student;
import com.metacube.EAD_Session_13.repository.StudentRepo;





@Service
public class ServiceClass {
	
	@Autowired
	private StudentRepo repo;
	
	@Transactional
    public void add(Student student) {
		repo.save(student);
    }
	
	@Transactional(readOnly=true)
    public List<Student> findAll() {
        return repo.findAll();
    }
	
	@Transactional(readOnly=true)
    public List<Student> findByNameIs(String name) {
        return repo.findByNameIs(name);
    }

    @Transactional(readOnly=true)
    public List<Student> findByfirstNameContainingIgnoreCase(String searchString) {
        return repo.findByfirstNameContainingIgnoreCase(searchString);
    }
}

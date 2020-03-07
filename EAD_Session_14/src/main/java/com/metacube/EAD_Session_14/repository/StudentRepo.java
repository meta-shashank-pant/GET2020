package com.metacube.EAD_Session_14.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.metacube.EAD_Session_14.model.Student;





@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
	
	public List<Student> findByfirstNameContainingIgnoreCase(String searchString);
	
	
	/** We can define a JPA query.**/
    @Query("select s from Student s where s.firstName = :firstName")
    public List<Student> findByNameIs(@Param("firstName") String name);

}

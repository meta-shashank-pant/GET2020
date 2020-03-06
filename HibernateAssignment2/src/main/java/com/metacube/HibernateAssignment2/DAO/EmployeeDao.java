package com.metacube.HibernateAssignment2.DAO;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.metacube.HibernateAssignment2.Model.Employee;


public interface EmployeeDao extends CrudRepository<Employee, Integer>{
	
	@Query("Select empId from Employee where emailId = :emailId")
	Integer findEmpIdByEmailId(@Param("emailId") String emailId);
	
	@Query("from Employee where orgName = :orgName and empId <> :empId")
	List<Employee> findFriends(@Param("orgName") String orgName, @Param("empId") int empId);
	
}

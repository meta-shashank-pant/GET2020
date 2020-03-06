package com.metacube.HibernateAssignment2.DAO;

import org.springframework.data.repository.CrudRepository;

import com.metacube.HibernateAssignment2.Model.Employee;
import com.metacube.HibernateAssignment2.Model.Vehicle;

public interface VehicleDao extends CrudRepository<Vehicle, Integer> {
	
	Vehicle findVehicleByEmployee(Employee employee);
}

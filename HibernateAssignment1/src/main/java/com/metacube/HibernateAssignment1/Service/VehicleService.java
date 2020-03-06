package com.metacube.HibernateAssignment1.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.HibernateAssignment1.DAOImpl.VehicleDaoImpl;
import com.metacube.HibernateAssignment1.Model.Employee;
import com.metacube.HibernateAssignment1.Model.Vehicle;

@Service
public class VehicleService {

	@Autowired
	private VehicleDaoImpl vehicleDao;

	@Transactional
	public int addVehicle(Vehicle vehicle) {
		return vehicleDao.addVehicle(vehicle);
	}

	@Transactional
	public Vehicle getVehicleById(int vehicleId) {
		return vehicleDao.getVehicle(vehicleId);
	}

	@Transactional
	public int updateVehicle(Vehicle vehicle) {
		System.out.println("In Service...");
		return vehicleDao.addVehicle(vehicle);
	}

	@Transactional
	public Vehicle getVehicleByEmpId(Employee employee) {
		return vehicleDao.getVehicleByEmpId(employee);
	}
}

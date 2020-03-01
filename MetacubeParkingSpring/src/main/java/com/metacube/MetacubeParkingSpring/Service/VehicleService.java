package com.metacube.MetacubeParkingSpring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.MetacubeParkingSpring.DAOImpl.VehicleDAOImpl;
import com.metacube.MetacubeParkingSpring.Model.Vehicle;


@Service
public class VehicleService {

	@Autowired
	private VehicleDAOImpl vehicleDao;

	public int addVehicle(Vehicle vehicle) {
		return vehicleDao.addVehicle(vehicle);
	}

	public Vehicle getVehicleById(int vehicleId) {
		return vehicleDao.getVehicle(vehicleId);
	}

	public boolean updateVehicle(Vehicle vehicle, int vehicleId) {
		return vehicleDao.updateVehicle(vehicle, vehicleId);
	}

	public int getVehicleIdByEmpId(int empId) {
		return vehicleDao.getVehicleIdByEmpId(empId);
	}
}

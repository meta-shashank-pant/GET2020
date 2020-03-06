package com.metacube.HibernateAssignment1.DAO;

import com.metacube.HibernateAssignment1.Model.Employee;
import com.metacube.HibernateAssignment1.Model.Vehicle;

public interface VehicleDao {
	String insertVehicle = "INSERT INTO Vehicle values (?, ?, ?, ?, ?, ?, ?);";
	String selectVehicle = "SELECT * FROM Vehicle where vehicleId = ?";
	String updateVehicle = "UPDATE Vehicle set vehicleName = ?, type = ?, vehicleNumber = ?"
			+ ", identification = ?, passId = ? where vehicleId = ?;";
	String lastRecord = "SELECT AUTO_INCREMENT FROM information_schema.TABLES"
			+ " WHERE TABLE_SCHEMA = 'metaparkingdbv2' AND TABLE_NAME = 'Vehicle'";
	String selectVehicleIdByEmpId = "SELECT vehicleId FROM Vehicle where empId = ?";

	Vehicle getVehicle(int vehicleId); 

	int addVehicle(Vehicle vehicle);

	Vehicle getVehicleByEmpId(Employee employee);
}

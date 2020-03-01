package com.metacube.MetacubeParkingSpring.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.metacube.MetacubeParkingSpring.DAO.VehicleDao;
import com.metacube.MetacubeParkingSpring.Model.Vehicle;
import com.metacube.MetacubeParkingSpring.connection.ConnectionUtility;

@Repository
public class VehicleDAOImpl implements VehicleDao {

	JdbcTemplate jdbcTemplate;

	@Autowired
	public VehicleDAOImpl(DataSource dataSource) {
		// TODO Auto-generated constructor stub
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Vehicle getVehicle(int vehicleId) {
		Vehicle vehicle = jdbcTemplate.queryForObject(selectVehicle, new Object[] {vehicleId}, new BeanPropertyRowMapper<>(Vehicle.class));
		return vehicle;
	}

	@Override
	public boolean updateVehicle(Vehicle vehicle, int vehicleId) {
		String vehicleName = vehicle.getVehicleName();
		String type = vehicle.getType();
		String vehicleNumber = vehicle.getVehicleNumber();
		String identification = vehicle.getIdentification();
		int passId = vehicle.getPassId();
		Object[] args = new Object[] {vehicleName, type, vehicleNumber, identification, passId, vehicleId};
		int[] mysqlArgTypes = new int[] {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.INTEGER};
		int rowsAffected = jdbcTemplate.update(updateVehicle, args, mysqlArgTypes);
		return rowsAffected != 0;
	}

	@Override
	public int addVehicle(Vehicle vehicle) {
		int vehicleId = -1;
		System.out.println("Inside add vehicle dao impl.");
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("Vehicle").usingColumns("vehicleName", "type", "vehicleNumber", "identification", "empId", "passId");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(vehicle);
		insertActor.execute(param);
		vehicleId = jdbcTemplate.queryForObject(lastRecord, new Object[0], Integer.class) - 1;
		System.out.println("Inside add vehicle dao impl:- vehicle id = "+vehicleId);
		return vehicleId;
	}

	@Override
	public int getVehicleIdByEmpId(int empId) {
		int vehicleId = jdbcTemplate.queryForObject(selectVehicleIdByEmpId, new Object[] {empId}, Integer.class);
		return vehicleId;
	}

}

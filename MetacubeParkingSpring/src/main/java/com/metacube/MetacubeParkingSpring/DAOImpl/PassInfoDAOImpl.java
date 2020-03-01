package com.metacube.MetacubeParkingSpring.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.MetacubeParkingSpring.DAO.PassInfo;
import com.metacube.MetacubeParkingSpring.connection.ConnectionUtility;

@Repository
public class PassInfoDAOImpl implements PassInfo {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public PassInfoDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public int getPassId(String passType, String vehicleType) {
		return jdbcTemplate.queryForObject(selectPassId, new Object[] {passType, vehicleType}, Integer.class);
	}

	@Override
	public String getPassType(int passId) {
		System.out.println();
		return jdbcTemplate.queryForObject(selectPassType, new Object[] {passId}, String.class);
	}

	@Override
	public double getPassPrice(int passId) {
		return jdbcTemplate.queryForObject(selectPassPrice, new Object[] {passId}, Double.class);
	}

}

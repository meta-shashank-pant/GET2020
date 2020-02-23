package com.metacube.MetacubeParkingSpring.DAO;
import com.metacube.MetacubeParkingSpring.Model.Pass;

public interface PassDao {
	String insertPass = "INSERT INTO Pass values (?, ?, ?, ?);";
	String selectPass = "SELECT * FROM Pass where passId = ?";
	String updatePass = "UPDATE Pass set passType = ?, passPrice = ?" + " where passId = ?";
	String lastRecord = "SELECT AUTO_INCREMENT FROM information_schema.TABLES"
			+ " WHERE TABLE_SCHEMA = 'parkingspring' AND TABLE_NAME = 'Pass'";

	Pass getPass(int passId);

	boolean updatePass(Pass pass);

	int addPass(Pass pass);
}

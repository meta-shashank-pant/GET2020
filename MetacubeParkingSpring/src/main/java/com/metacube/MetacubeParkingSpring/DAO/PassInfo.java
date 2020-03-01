package com.metacube.MetacubeParkingSpring.DAO;

public interface PassInfo {
	String selectPassId = "SELECT PassId from PassInfo" + " where passType = ? and vehicleType = ?;";
	String selectPassType = "SELECT PassType from PassInfo where passId = ?;";
	String selectPassPrice = "SELECT PassPrice from PassInfo  where passId = ?;";

	int getPassId(String passType, String vehicleType);

	String getPassType(int passId);

	double getPassPrice(int passId);
}

package com.metacube.HibernateAssignment1.DAO;

import com.metacube.HibernateAssignment1.Model.PassInfo;

public interface PassInfoDao {
	String selectPassId = "SELECT PassId from PassInfo" + " where passType = ? and vehicleType = ?;";
	String selectPassType = "SELECT PassType from PassInfo where passId = ?;";
	String selectPassPrice = "SELECT PassPrice from PassInfo  where passId = ?;";

	PassInfo getPassInfo(String passType, String vehicleType);

	String getPassType(int passId);

	double getPassPrice(int passId);
}

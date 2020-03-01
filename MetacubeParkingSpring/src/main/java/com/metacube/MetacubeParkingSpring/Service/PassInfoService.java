package com.metacube.MetacubeParkingSpring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.metacube.MetacubeParkingSpring.DAOImpl.PassInfoDAOImpl;

@Service
public class PassInfoService {
	@Autowired
	private PassInfoDAOImpl passInfoDao;

	public int getPassId(String vehicleType, String passType) {
		return passInfoDao.getPassId(passType, vehicleType);
	}

	public String getPassType(int passId) {
		return passInfoDao.getPassType(passId);
	}

	public double getPassPrice(int passId) {
		return passInfoDao.getPassPrice(passId);
	}
}

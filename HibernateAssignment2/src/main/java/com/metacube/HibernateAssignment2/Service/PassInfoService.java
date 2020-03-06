package com.metacube.HibernateAssignment2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.HibernateAssignment2.DAO.PassInfoDao;
import com.metacube.HibernateAssignment2.Model.PassInfo;


@Service
public class PassInfoService {

	@Autowired
	private PassInfoDao passInfoDao;

	public PassInfo getPassInfo(String vehicleType, String passType) {
		return passInfoDao.findPassInfoByPassTypeAndVehicleType(passType, vehicleType);
	}

	public String getPassType(int passId) {
		return  passInfoDao.findById(passId).orElse(new PassInfo()).getPassType();
	}

	public double getPassPrice(int passId) {
		return passInfoDao.findById(passId).orElse(new PassInfo()).getPassPrice();
	}
}

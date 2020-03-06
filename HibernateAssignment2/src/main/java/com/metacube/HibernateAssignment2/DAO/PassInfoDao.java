package com.metacube.HibernateAssignment2.DAO;

import org.springframework.data.repository.CrudRepository;

import com.metacube.HibernateAssignment2.Model.PassInfo;

public interface PassInfoDao extends CrudRepository<PassInfo, Integer>{
	
	PassInfo findPassInfoByPassTypeAndVehicleType(String passType, String vehicleType);
}

package com.metacube.MetacubeParkingSpring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.MetacubeParkingSpring.DAOImpl.PassDAOImpl;
import com.metacube.MetacubeParkingSpring.Model.Pass;

@Service
public class PassService {
	@Autowired
	private PassDAOImpl passDao;

	public int generatePass(Pass pass) {
		return passDao.addPass(pass);
	}
}

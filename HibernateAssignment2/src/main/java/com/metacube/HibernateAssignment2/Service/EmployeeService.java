package com.metacube.HibernateAssignment2.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.HibernateAssignment2.DAO.EmployeeDao;
import com.metacube.HibernateAssignment2.Model.Employee;


@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Transactional
	public int addEmployee(Employee employee) {
		Employee emp = employeeDao.save(employee);
		return emp.getEmpId();
	}

	@Transactional
	public Employee getEmployeeById(int empId) {
		return employeeDao.findById(empId).orElse(new Employee());
	}

	@Transactional
	public int getEmployeeId(String emailId) {
		
		Integer empId = employeeDao.findEmpIdByEmailId(emailId);
		if (empId == null) {
			return -1;
		}
		return empId;
	}
	
	@Transactional
	public Employee updateEmployee(Employee employee) {
		return employeeDao.save(employee);
	}

	@Transactional
	public List<Employee> getFriends(int empId) {
		Employee employee = employeeDao.findById(empId).orElse(new Employee());
		return employeeDao.findFriends(employee.getOrgName(), empId);
	}
}

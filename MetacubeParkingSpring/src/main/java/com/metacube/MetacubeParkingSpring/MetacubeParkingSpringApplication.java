package com.metacube.MetacubeParkingSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.metacube.MetacubeParkingSpring.Config.ParkingConfig;
import com.metacube.MetacubeParkingSpring.DAO.EmployeeDao;
import com.metacube.MetacubeParkingSpring.DAO.PassDao;
import com.metacube.MetacubeParkingSpring.DAO.PassInfo;
import com.metacube.MetacubeParkingSpring.DAO.VehicleDao;
import com.metacube.MetacubeParkingSpring.DAOImpl.EmployeeDAOImpl;
import com.metacube.MetacubeParkingSpring.DAOImpl.PassDAOImpl;
import com.metacube.MetacubeParkingSpring.DAOImpl.VehicleDAOImpl;
import com.metacube.MetacubeParkingSpring.Model.Employee;
import com.metacube.MetacubeParkingSpring.Model.Pass;
import com.metacube.MetacubeParkingSpring.Model.Vehicle;

@SpringBootApplication
public class MetacubeParkingSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(MetacubeParkingSpringApplication.class, args);
		//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ParkingConfig.class);
		
//		EmployeeDao emp = context.getBean(EmployeeDao.class);
//		
//		Employee my_emp = new Employee();
//		my_emp.setFullName("Shashank Pant 3");
//		my_emp.setGender("Male");
//		my_emp.setEmailId("shashankpant16698@gmail.com");
//		my_emp.setPassword("CHANGED");
//		my_emp.setConfirmPassword("CHANGED");
//		my_emp.setContactNumber("0987654321");
//		my_emp.setOrgName("Metacube 1");
		
		//emp.addEmployee(my_emp);
		
//		System.out.println("UPDATE ***** ");
//		emp.updateEmployee(4, my_emp);
//		System.out.println("DELETE *****");
//		System.out.println(emp.getEmployeeById(3));
//		System.out.println("GET ID ****");
//		System.out.println(emp.getEmployeeId(my_emp.getEmailId()));
		
//		VehicleDao vd = context.getBean(VehicleDao.class);
//		Vehicle vehicle = new Vehicle();
//		vehicle.setVehicleName("Wagonr");
//		vehicle.setEmpId(4);
//		vehicle.setIdentification("White Car");
//		vehicle.setVehicleNumber("RJ146672");
//		vehicle.setType("Four Wheeler");
//		vehicle.setPassId(6);
//		vd.updateVehicle(vehicle, 4);
//		
//		System.out.println(vd.getVehicle(4));
		
//		PassInfo pi = context.getBean(PassInfo.class);
//		System.out.println("+++++ "+pi.getPassType(9));
	}

}

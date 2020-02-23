package com.metacube.MetacubeParkingSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.metacube.MetacubeParkingSpring.DAO.EmployeeDao;
import com.metacube.MetacubeParkingSpring.DAO.PassDao;
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
//		EmployeeDao emp = new EmployeeDAOImpl();
//		Employee my_emp = new Employee();
//		my_emp.setEmpId(1234);
//		my_emp.setFullName("Shashank Pant");
//		my_emp.setGender("Male");
//		my_emp.setEmailId("shashankpant16@gmail.com");
//		my_emp.setPassword("password");
//		my_emp.setConfirmPassword("password");
//		my_emp.setContactNumber("0987654321");
//		my_emp.setOrgName("Metacube 1");
//		emp.addEmployee(my_emp);
//		VehicleDao vd = new VehicleDAOImpl();
//		Vehicle vehicle = new Vehicle();
//		vehicle.setEmpId(1234);
//		vehicle.setIdentification("Black");
//		vehicle.setPassId(2345);
//		vehicle.setType("Car");
//		vehicle.setVehicleId(4571);
//		vehicle.setVehicleNumber("qwert1234");
//		vehicle.setVehicleName("Honda City");
//		vd.addVehicle(vehicle);
//		PassDao pd=  new PassDAOImpl();
//		Pass pass = new Pass();
//		pass.setPassId(125);
//		pass.setPassPrice(25.5);
//		pass.setPassType("monthly");
//		pass.setVehicleId(1234);
//		//pd.addPass(pass);
//		Pass mp = pd.getPass(125);
//		System.out.println("1. "+mp.getPassId()+" 2. "+mp.getPassPrice()+" 3. "+mp.getPassType()+" 4. "+mp.getVehicleId());
	}

}

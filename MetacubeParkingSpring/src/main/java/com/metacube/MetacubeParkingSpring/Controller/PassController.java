package com.metacube.MetacubeParkingSpring.Controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.metacube.MetacubeParkingSpring.Model.EmployeeLogin;
import com.metacube.MetacubeParkingSpring.Model.Pass;
import com.metacube.MetacubeParkingSpring.Model.Vehicle;
import com.metacube.MetacubeParkingSpring.Service.PassInfoService;
import com.metacube.MetacubeParkingSpring.Service.PassService;
import com.metacube.MetacubeParkingSpring.Service.VehicleService;


@Controller
public class PassController {

	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private PassService passService;

	@Autowired
	private PassInfoService passInfoService;

	public static boolean isSessionValid(HttpSession session, HttpServletResponse res) {
		res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if (session.getAttribute("empId") == null) {
			return false;
		}
		return true;
	}

	@PostMapping("/addPass")
	public String generatePass(@Valid @ModelAttribute("pass") Pass pass, Errors errors, Model model) {
		if (errors.hasErrors()) {
			return "pass";
		} else {
			passService.generatePass(pass);
			Vehicle vehicle = vehicleService.getVehicleById(pass.getVehicleId());
			String vehicleType = vehicle.getType();
			String passType = pass.getPassType();
			int passId = passInfoService.getPassId(vehicleType, passType);
			vehicle.setPassId(passId);
			System.out.println(vehicleService.updateVehicle(vehicle, pass.getVehicleId()));
			model.addAttribute("employeeDto", new EmployeeLogin());
			return "redirect:login";
		}
	}

	@GetMapping("/getPassDetails")
	public String getPassDetails(Model model, HttpSession session, HttpServletResponse res) {
		if (isSessionValid(session, res)) {
			int empId = (int) session.getAttribute("empId");
			int vehicleId = vehicleService.getVehicleIdByEmpId(empId);
			Vehicle vehicle = vehicleService.getVehicleById(vehicleId);

			Pass pass = new Pass();
			pass.setPassId(vehicle.getPassId());
			pass.setVehicleId(vehicleId);
			pass.setPassType(passInfoService.getPassType(vehicle.getPassId()));
			pass.setPassPrice(passInfoService.getPassPrice(vehicle.getPassId()));
			System.out.println("**** "+pass);

			model.addAttribute("pass", pass);
			model.addAttribute("vehicleType", vehicle.getType());

			return "showPassDetails";
		} else {
			return "redirect:login";
		}
	}

	@PostMapping("/editPass")
	public String updateEmployeeDetails(@Valid @ModelAttribute("employee") Pass pass, Errors errors,
			HttpSession session) {
		passService.generatePass(pass);
		int empId = (int) session.getAttribute("empId");
		int vehicleId = vehicleService.getVehicleIdByEmpId(empId);
		Vehicle vehicle = vehicleService.getVehicleById(vehicleId);
		String passType = pass.getPassType();
		int passId = passInfoService.getPassId(vehicle.getType(), passType);
		vehicle.setPassId(passId);
		vehicleService.updateVehicle(vehicle, vehicleId);
		return "redirect:getPassDetails";
	}
}

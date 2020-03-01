package com.metacube.MetacubeParkingSpring.Controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.metacube.MetacubeParkingSpring.Model.Employee;
import com.metacube.MetacubeParkingSpring.Model.EmployeeLogin;


@Controller
public class HomeController {
	
	@GetMapping({ "/", "/home" })
	public String getHomePage() {
		System.out.println("In home controller...");
		return "home";
	}

	@GetMapping("/register")
	public String getRegisterPage(Model model) {
		model.addAttribute("employee", new Employee());
		return "register";
	}

	@GetMapping("/login")
	public String getLoginPage(Model model) {
		model.addAttribute("employeeDto", new EmployeeLogin());
		return "login";
	}

	@GetMapping("/display")
	public String getDisplayPage(HttpSession session, HttpServletResponse res) {
		if (isSessionValid(session, res)) {
			return "display";
		} else {
			return "redirect:login";
		}
	}

	private boolean isSessionValid(HttpSession session, HttpServletResponse res) {
		// TODO Auto-generated method stub
		res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if (session.getAttribute("empId") == null) {
			return false;
		}
		return true;
	}
}

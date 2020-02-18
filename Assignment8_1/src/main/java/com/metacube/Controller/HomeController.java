package com.metacube.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.models.Student;
import com.metacube.service.StudentService;


@Controller
public class HomeController {
	
	@Autowired
	private StudentService studentService;

	@GetMapping({"/","/home"})
	public String showHomePage() {
		return "home";
	}
	
	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("student",new Student());
		
		return "registration";
	}
	
	@PostMapping("/registration")
	public String doRegistration(@Validated @ModelAttribute("student") Student student, BindingResult bindingResult ) {

		if(bindingResult.hasErrors()) {

			return "registration";
		}else {

			if(student.getId() == null) {

				studentService.addStudent(student);	
			}else {
				studentService.updateStudent(student);
			}


			return "redirect:/display";
		}



	}
}

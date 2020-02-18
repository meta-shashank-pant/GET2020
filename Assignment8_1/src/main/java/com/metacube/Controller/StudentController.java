package com.metacube.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.models.Student;
import com.metacube.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
//	@GetMapping("display")
//	public ModelAndView showDisplay(Student info) {
//		
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("info", info);
//		mv.setViewName("display");
//		return mv;
//	}
	
	@GetMapping("/display")
	public ModelAndView students() {
		List<Student> students =  studentService.getAllStudent();
		return new ModelAndView("display","students",students);
	}

	@GetMapping("/display/{id}")
	public ModelAndView students(@PathVariable("id") int id) {
		return new ModelAndView("registration","student",studentService.getStudent(id));
	}
	
}

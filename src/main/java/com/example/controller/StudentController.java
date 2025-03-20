package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;
import com.example.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/")
	public String getMethodName(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("allStudents", studentService.getAllStudents());
		return "index";
	}
	
	@PostMapping("/add")
	public String postMethodName(@ModelAttribute Student student) {
		studentService.addStudent(student);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") Integer id) {
		studentService.deleteStudentById(id);
		return "redirect:/";
	}
	
	@GetMapping("/update/{id}")
	public String updateStudent(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "update-page";
	}

	@PostMapping("update-student")
	public String UpdateStudentPost(
			@RequestParam("id") Integer id,
			@RequestParam("name") String name,
			@RequestParam("address") String address,
			@RequestParam("marks") String marks
			
			) {
		Student s = studentService.getStudentById(id);
		s.setName(name);
		s.setAddress(address);
		s.setMarks(Double.parseDouble(marks));
		studentService.updateStudent(s);
		
		return "redirect:/";
	}
	
}

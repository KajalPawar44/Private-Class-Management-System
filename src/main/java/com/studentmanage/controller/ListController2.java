package com.studentmanage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentmanage.model.Student;
import com.studentmanage.model.Trainer;
import com.studentmanage.service.StudentService;
import com.studentmanage.service.TrainerService;

@Controller
public class ListController2 {

	@Autowired
	private StudentService studentservice;
	
	@GetMapping("/StudentAdminlogin")
	public String admin() {
		return "Admin";
	}
	
	 @PostMapping("Student/admin/login")
	    public String handleLogin(@RequestParam String username, @RequestParam String password, Model model) {
	        if ("kajal".equals(username) && "kajal123".equals(password)) {
	            return "redirect:/viewStudent2"; 
	        }
	        model.addAttribute("error", "Invalid username or password");
	        return "StudentAdminlogin";
	    }

	
}

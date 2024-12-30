package com.studentmanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
	@GetMapping("/Adminlogin")
	public String admin() {
		return "Admin";
	}
	 @PostMapping("/admin/login")
	    public String handleLogin(@RequestParam String username, @RequestParam String password, Model model) {
	        // Add your authentication logic here
	        if ("kajal".equals(username) && "kajal123".equals(password)) {
	            return "redirect:/viewStudent1"; // Redirect on successful login
	        }
	        model.addAttribute("error", "Invalid username or password");
	        return "Adminlogin";
	    }
}

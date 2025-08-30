package com.studentmanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    
    @GetMapping("/admin/login")
    public String adminLoginForm(Model model) {
        return "login";  
    }

   
    @GetMapping("/welcome")
    public String welcomePage() {
        return "Welcome_SMSystem";
    }

    // Trainer login page
    @GetMapping("/Trainer123")
    public String showTrainerLoginPage() {
        return "TrianerAdm"; 
    }

    // Student login page
    @GetMapping("/Student123")
    public String showStudentLoginPage() {
        return "StudentAdmin"; 
    }

    // Handle student login
    @PostMapping("/Student1")
    public String handleStudentLogin(@RequestParam String username, @RequestParam String password) {
        if (username.equals("kajal") && password.equals("kajal123")) {
            return "redirect:/viewStudent2";  
        } else {
            return "StudentAdmin"; 
        }
    }

    @PostMapping("/TrainerLogin")
    public String processTrainerLogin(@RequestParam String username,
                                      @RequestParam String password,
                                      Model model) {
        if (username.equals("kajal") && password.equals("kajal123")) {
            return "redirect:/viewTrainers"; 
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "TrianerAdm";
        }
    }
}

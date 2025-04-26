package com.studentmanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TrainerAdmin {

    @GetMapping("/trainer/login")
    public String trainerLoginForm() {
        return "TrainerAdm";
    }

    @PostMapping("/trainer/login")
    public String handleTrainerLogin(
            @RequestParam String username,
            @RequestParam String password,
            Model model) {
        
        if ("kajal".equals(username) && "kajal123".equals(password)) {
            return "redirect:/viewTrainers";
        }
        model.addAttribute("error", "Invalid username or password");
        return "TrainerLogin";
    }
}
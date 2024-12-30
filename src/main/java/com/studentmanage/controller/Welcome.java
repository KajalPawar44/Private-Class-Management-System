package com.studentmanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Welcome {
	@GetMapping("/welcome")
    public String welcome() {
        return "Welcome_SMSystem"; // The Thymeleaf template name
    }
}

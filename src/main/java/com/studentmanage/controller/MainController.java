package com.studentmanage.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/Main")
    public String welcome() {
        return "Welcome_SMSystem";
    }
}
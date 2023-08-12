package com.maybank.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/")
    public String welcome() {
        return "Welcome to Spring Boot Training";
    }
    
    @GetMapping("/wc")
    public String welcome1(@RequestParam("name") String name) {
    	System.out.println(name);
    	return "Welcome to Spring Boot Training" + name; 
    }
}

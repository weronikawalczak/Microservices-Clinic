package com.eureka.auth.controller;

import com.eureka.auth.AuthService;
import com.eureka.auth.model.MedicalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService service;

    @PostMapping("/register")
    public MedicalUser registerUser(@RequestParam MedicalUser user) {
       return service.saveUser(user);
    }

    @GetMapping("/public")
    public String securedMethod() {
        return "test";
    }
}



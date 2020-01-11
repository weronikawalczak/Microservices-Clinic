package com.eureka.auth.controller;

import com.eureka.auth.model.MedicalUser;
import com.eureka.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService service;

    @PostMapping("/register")
    public MedicalUser registerUser(@RequestBody MedicalUser user) {
       return service.saveUser(user);
    }
}



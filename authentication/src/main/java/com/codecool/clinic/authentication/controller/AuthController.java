package com.codecool.clinic.authentication.controller;

import com.codecool.clinic.authentication.service.AuthService;
import com.codecool.clinic.authentication.model.MedicalUser;
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



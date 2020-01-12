package com.codecool.clinic.authentication.controller;

import com.codecool.clinic.authentication.service.AuthService;
import com.codecool.clinic.authentication.model.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService service;

    @PostMapping("/register")
    public SystemUser registerUser(@RequestBody SystemUser user) {
       return service.saveUser(user);
    }
}



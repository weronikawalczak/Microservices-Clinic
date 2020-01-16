package com.codecool.clinic.authentication.controller;

import com.codecool.clinic.authentication.service.AuthService;
import com.codecool.clinic.authentication.model.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    AuthService service;

    @PostMapping("/register")
    public AuthUser registerUser(@RequestBody AuthUser user) {
        return service.saveUser(user);
    }
}



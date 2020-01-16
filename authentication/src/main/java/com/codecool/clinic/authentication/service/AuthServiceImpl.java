package com.codecool.clinic.authentication.service;

import com.codecool.clinic.authentication.client.AuthClient;
import com.codecool.clinic.authentication.model.AuthUser;
import com.codecool.clinic.authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AuthServiceImpl implements AuthService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthClient authClient;

    public AuthUser saveUser(AuthUser user){
        user.setRole("PATIENT");
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

        userRepository.save(user);
        authClient.registerPatient(user);
        return user;
    }
}



package com.codecool.clinic.authentication.service;

import com.codecool.clinic.authentication.model.MedicalUser;
import com.codecool.clinic.authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AuthServiceImpl implements AuthService{

    @Autowired
    UserRepository userRepository;

    public MedicalUser saveUser(MedicalUser user){
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }
}



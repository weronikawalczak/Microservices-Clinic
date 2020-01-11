package com.eureka.auth.service;

import com.eureka.auth.model.MedicalUser;
import com.eureka.auth.repository.UserRepository;
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



package com.eureka.auth;

import com.eureka.auth.model.MedicalUser;
import com.eureka.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthService {

    @Autowired
    UserRepository userRepository;

    public MedicalUser saveUser(MedicalUser user){
        return userRepository.save(user);
    }
}



package com.eureka.auth.service;

import com.eureka.auth.model.MedicalUser;

public interface AuthService {
    MedicalUser saveUser(MedicalUser user);
}

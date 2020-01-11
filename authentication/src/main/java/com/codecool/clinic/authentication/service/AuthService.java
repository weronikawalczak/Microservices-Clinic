package com.codecool.clinic.authentication.service;

import com.codecool.clinic.authentication.model.MedicalUser;

public interface AuthService {
    MedicalUser saveUser(MedicalUser user);
}

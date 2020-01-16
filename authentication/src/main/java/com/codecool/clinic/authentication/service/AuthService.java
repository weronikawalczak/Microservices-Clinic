package com.codecool.clinic.authentication.service;

import com.codecool.clinic.authentication.model.AuthUser;

public interface AuthService {
    AuthUser saveUser(AuthUser user);
}

package com.codecool.clinic.authentication.service;

import com.codecool.clinic.authentication.model.SystemUser;

public interface AuthService {
    SystemUser saveUser(SystemUser user);
}

package com.codecool.clinic.authentication.client;

import com.codecool.clinic.authentication.model.AuthUser;

public interface AuthClient {
    void registerPatient(AuthUser authUser);
}

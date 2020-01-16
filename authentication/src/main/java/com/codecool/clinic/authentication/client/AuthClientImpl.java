package com.codecool.clinic.authentication.client;

import com.codecool.clinic.authentication.model.AuthUser;
import com.codecool.clinic.protocol.UserDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthClientImpl implements AuthClient{
    @Autowired
    RestTemplate restTemplate;

    @Override
    public void registerPatient(AuthUser authUser){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(authUser.getId());
        userDTO.setUsername(authUser.getUsername());
        restTemplate.postForObject("http://patient-service/register", userDTO , UserDTO.class);
    }
}

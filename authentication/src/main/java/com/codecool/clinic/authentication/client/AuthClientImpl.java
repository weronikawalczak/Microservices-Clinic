package com.codecool.clinic.authentication.client;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthClientImpl implements AuthClient{

    @Autowired
    RestTemplate restTemplate;

    @Override
    public void callPatient(){
        restTemplate.getForObject("http://patient-service/hello", String.class);
    }
}

package com.codecool.clinic.patient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient    // Enable eureka client. It inherits from @EnableDiscoveryClient.
public class PatientApp {
    public static void main(String[] args) {
        SpringApplication.run(PatientApp.class, args);
    }
}



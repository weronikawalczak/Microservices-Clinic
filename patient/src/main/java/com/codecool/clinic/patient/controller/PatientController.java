package com.codecool.clinic.patient.controller;

import com.codecool.clinic.patient.model.Patient;
import com.codecool.clinic.patient.service.PatientService;
import com.codecool.clinic.protocol.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class PatientController {

    @Autowired
    PatientService service;

    @PostMapping("/register")
    public UserDTO registerPatient(@RequestBody UserDTO userDTO) {
        //move to service
        //in patient class create method ofUserDTO(userDTO)
        Patient patient = new Patient();
        patient.setFirstName("FirstName");
        patient.setLastName("LastName");
        patient.setUserUUID(userDTO.getId());
        service.savePatient(patient);
        return userDTO;
    }

    @GetMapping("/hello")
    public String sayHello() {
        System.out.println("HeyHey");
        return "Hello";
    }
}

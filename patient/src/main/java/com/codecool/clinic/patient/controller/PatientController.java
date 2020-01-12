package com.codecool.clinic.patient.controller;

import com.codecool.clinic.patient.model.Patient;
import com.codecool.clinic.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientService service;

    @PostMapping("/register")
    public Patient registerPatient(@RequestBody Patient patient) {
        return service.savePatient(patient);
    }
}

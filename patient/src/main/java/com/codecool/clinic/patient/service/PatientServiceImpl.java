package com.codecool.clinic.patient.service;

import com.codecool.clinic.patient.model.Patient;
import com.codecool.clinic.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PatientServiceImpl implements PatientService{
   @Autowired
    PatientRepository patientRepository;


    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }
}

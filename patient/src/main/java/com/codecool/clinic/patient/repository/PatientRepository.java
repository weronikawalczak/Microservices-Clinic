package com.codecool.clinic.patient.repository;

import com.codecool.clinic.patient.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}

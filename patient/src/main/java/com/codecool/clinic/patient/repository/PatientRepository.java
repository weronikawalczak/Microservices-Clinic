package com.codecool.clinic.patient.repository;

import com.codecool.clinic.patient.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    Optional<Patient> findById(Integer id);
    List<Patient> findAll();
}

package com.codecool.clinic.patient.controller;

import com.codecool.clinic.patient.model.Patient;
import com.codecool.clinic.patient.repository.PatientRepository;
import com.codecool.clinic.patient.service.PatientService;
import com.codecool.clinic.protocol.UserDTO;
import org.graalvm.compiler.nodes.calc.IntegerDivRemNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

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

    @GetMapping("/list")
    public List<Patient> list() {
        return patientRepository.findAll();
    }

    @GetMapping("/id/{id}")
    public Optional<Patient> getPatient(@PathVariable Integer id) {
        return patientRepository.findById(id);
    }

    @PutMapping("/edit/{id}")
    public UserDTO editPatient(@PathVariable Integer id, @RequestBody UserDTO userDTO) {
        Optional<Patient> patientToChange = getPatient(id);
//        patientToChange.get().setFirstName(userDTO);
//        patientToChange.get().setLastName();
        return userDTO;
    }
}


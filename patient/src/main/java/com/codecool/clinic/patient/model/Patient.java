package com.codecool.clinic.patient.model;

import javax.persistence.*;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Integer id;

    private Integer userUUID;

    @Column(unique = true)
    private String username;

    private String firstName;
    private String lastName;
}

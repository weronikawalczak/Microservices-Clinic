package com.codecool.clinic.patient.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
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

package com.eureka.auth.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "medicalUser")
public class MedicalUser {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Integer id;

    @Column(unique = true)
    private String username;

    @Setter
    private String password;
    private String role;
}

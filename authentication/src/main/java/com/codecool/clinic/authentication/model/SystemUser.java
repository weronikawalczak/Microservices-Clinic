package com.codecool.clinic.authentication.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "system_user")
public class SystemUser {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Integer id;

    @Column(unique = true)
    private String username;

    @Setter
    private String password;
    private String role;
}

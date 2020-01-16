package com.codecool.clinic.protocol;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Integer id;
    private String username;
    private String password;
    private String role;
}

package com.example.demo.controller.model;


import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class RegistrationDto {

    @NotEmpty(message = "username may not be empty")
    @NotNull(message = "username may not be null")
    private String username;

    @NotEmpty(message = "password may not be empty")
    @NotNull(message = "password may not be null")
    private String password;

    @NotEmpty(message = "firstName may not be empty")
    @NotNull(message = "firstName may not be null")
    private String firstName;

    @NotEmpty(message = "lastName may not be empty")
    @NotNull(message = "lastName may not be null")
    private String lastName;

    @NotEmpty(message = "mail may not be empty")
    @NotNull(message = "mail may not be null")
    private String mail;

}

package com.example.spring_demo.domain.dto.in.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
public class UserUpdate extends UserCreate{

    private String firstName;

    private String lastName;

    private Number year;

    @Email(message = "Vous devez entrer une adresse mail")
    private String email;

    private String password;

    @NotNull()
    private UUID user_id;

    private Date updateDate = new Date();

}

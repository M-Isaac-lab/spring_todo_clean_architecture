package com.example.spring_demo.domain.dto.in.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdate{

    private String firstName;

    private String lastName;

    private Number year;

    @Email(message = "Vous devez entrer une adresse mail")
    private String email;

    private String password;

    @NotNull()
    private UUID id;

    private Date updateDate = new Date();

}

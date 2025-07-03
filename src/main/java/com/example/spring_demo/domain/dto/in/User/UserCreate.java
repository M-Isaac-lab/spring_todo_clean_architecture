package com.example.spring_demo.domain.dto.in.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCreate {

    @NotBlank(message = "Le firstName est obligatoire")
    private String firstName;

    @NotBlank(message = "Le lastName est obligatoire")
    private String lastName;

    private Number year;

    @Email(message = "Vous devez entrer une adresse mail")
    @NotBlank(message = "L'adresse mail est obligatoire")
    private String email;

    @NotNull(message = "Veuillez entrer un password")
    private String password;

}

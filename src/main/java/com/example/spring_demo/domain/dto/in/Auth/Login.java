package com.example.spring_demo.domain.dto.in.Auth;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Login {

    @NotBlank(message = "L'email est obligatoire")
    private String email;

    @NotBlank(message = "Le password est obligatoire")
    private String password;
}

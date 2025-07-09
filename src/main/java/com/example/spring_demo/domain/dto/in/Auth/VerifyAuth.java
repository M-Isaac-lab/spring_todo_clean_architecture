package com.example.spring_demo.domain.dto.in.Auth;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VerifyAuth {

    @NotBlank(message = "L'ID est obligatoire")
    private UUID id;
}

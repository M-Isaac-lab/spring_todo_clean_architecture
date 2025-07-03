package com.example.spring_demo.domain.dto.in.Todo;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoCreate {

    @NotBlank(message = "le titre est obligatoire")
    private String title;

    private String description;

    @NotNull(message = "L'identifiant de l'utilisateur est obligatoire")
    private UUID user_id;

}

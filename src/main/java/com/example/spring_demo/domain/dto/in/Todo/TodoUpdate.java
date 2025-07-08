package com.example.spring_demo.domain.dto.in.Todo;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TodoUpdate {

    @NotNull(message = "L'identifiant de la todo est obligatoire")
    private UUID id;

    private String title;

    private String description;

    private UUID user_id;
}

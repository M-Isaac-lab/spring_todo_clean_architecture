package com.example.spring_demo.domain.dto.in.Todo;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
public class TodoUpdate {

    @NotNull(message = "L'identifiant de la todo est obligatoire")
    private UUID todo_id;

    private String title;

    private String description;

    private UUID user_id;
}

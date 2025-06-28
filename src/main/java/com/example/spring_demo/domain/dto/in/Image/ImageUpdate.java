package com.example.spring_demo.domain.dto.in.Image;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
public class ImageUpdate {

    private String image_url;

    private UUID todo_id;

    @NotNull(message = "l'ID de l'image est obligatoire")
    private String image_id;


}

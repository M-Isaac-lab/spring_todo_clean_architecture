package com.example.spring_demo.domain.dto.in.Image;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
public class ImageCreate {

    @NotNull(message = "Veuillez entrer l'url de l'image")
    private String image_url;

    @NotBlank(message = "L'ID de la todo est obligatoire")
    private UUID todo_id;
}

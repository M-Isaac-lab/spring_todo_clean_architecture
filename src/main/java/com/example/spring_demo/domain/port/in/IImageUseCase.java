package com.example.spring_demo.domain.port.in;

import com.example.spring_demo.domain.model.ImageModel;

import java.util.List;
import java.util.UUID;

public interface IImageUseCase {
    ImageModel findOneImage(String image_id);
    ImageModel createImage(ImageModel image);
    void deleteImage(String image_id);
    List<ImageModel> findAllImage();
    List<ImageModel> findByTodo(UUID todo_id);

}

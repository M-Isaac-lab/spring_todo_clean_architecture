package com.example.spring_demo.domain.dto.out;

import com.example.spring_demo.domain.model.ImageModel;
import com.example.spring_demo.domain.model.UserModel;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateTodoReponse {

    private UUID todo_id;
    private String title;
    private String description;
    private Date created_at;
    private Date updated_at;
    private UUID user_id;
    private List<ImageModel> Images;


}

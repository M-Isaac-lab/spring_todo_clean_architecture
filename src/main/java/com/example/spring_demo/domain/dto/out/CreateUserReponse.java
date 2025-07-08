package com.example.spring_demo.domain.dto.out;

import com.example.spring_demo.domain.model.TodoModel;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor

public class CreateUserReponse {

    private UUID id;
    private String first_name;
    private String last_name;
    private Number year;
    private String email;
    //private String password;
    private String token;
    private Boolean active;
    private Date created_at;
    private Date updated_at;
    private List<TodoModel> Todos;


}

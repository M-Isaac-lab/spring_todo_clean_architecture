package com.example.spring_demo.domain.dto.out;

import lombok.*;

import java.util.Date;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateImageReponse {
    private String image_url;
    private Date created_at;
    private UUID todo_id;
    private Number id;

}

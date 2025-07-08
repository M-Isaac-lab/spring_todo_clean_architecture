package com.example.spring_demo.domain.mapper;

import com.example.spring_demo.domain.dto.out.CreateUserReponse;
import com.example.spring_demo.domain.model.UserModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMapper {

    public CreateUserReponse userDto(UserModel user) {
        return new CreateUserReponse(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getYear(),
                user.getEmail(),
                user.getToken(),
                user.getActivate(),
                user.getCreatedAt(),
                user.getUpdateAt(),
                user.getTodos()
        );
    }

        public List<CreateUserReponse> userDtoList(List<UserModel> users){
            return users.stream().map(this::userDto).toList();
        }
    }


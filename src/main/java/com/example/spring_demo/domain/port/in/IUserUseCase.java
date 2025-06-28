package com.example.spring_demo.domain.port.in;

import com.example.spring_demo.domain.dto.in.User.UserCreate;
import com.example.spring_demo.domain.dto.in.User.UserUpdate;
import com.example.spring_demo.domain.dto.out.CreateUserReponse;
import com.example.spring_demo.domain.model.UserModel;

import java.util.List;
import java.util.UUID;

public interface IUserUseCase {
    CreateUserReponse findOneUser(UUID user_id);
    void createOneUser(UserCreate user);
    void updateUser(UserUpdate user);
    void deleteUser(UUID user_id);
    List<CreateUserReponse> findAllUser();
}

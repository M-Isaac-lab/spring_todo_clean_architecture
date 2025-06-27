package com.example.spring_demo.domain.port.in;

import com.example.spring_demo.domain.model.UserModel;

import java.util.List;
import java.util.UUID;

public interface IUserUseCase {
    UserModel findOneUser(UUID user_id);
    void createOneUser(UserModel user);
    void updateUser(UserModel user);
    void deleteUser(UUID user_id);
    List<UserModel> findAllUser();
}

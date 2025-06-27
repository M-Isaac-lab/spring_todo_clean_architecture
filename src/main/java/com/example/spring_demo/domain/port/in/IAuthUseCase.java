package com.example.spring_demo.domain.port.in;

import com.example.spring_demo.domain.model.UserModel;

public interface IAuthUseCase {
    UserModel login(String email, String password);
    void register(UserModel user);
    UserModel verifyauth(String otp, String user_id);
}

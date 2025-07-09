package com.example.spring_demo.application.service;

import com.example.spring_demo.domain.config.JwtUtils;
import com.example.spring_demo.domain.dto.in.Auth.VerifyAuth;
import com.example.spring_demo.domain.dto.in.User.UserCreate;
import com.example.spring_demo.domain.dto.out.CreateUserReponse;
import com.example.spring_demo.domain.model.UserModel;
import com.example.spring_demo.domain.port.in.IAuthUseCase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor

public class authService implements IAuthUseCase, UserDetailsService {




    @Qualifier("AuthServiceImpl")
    private final IAuthUseCase authUseCase;

    @Override
    public CreateUserReponse login(String email, String password) {
        return authUseCase.login(email, password);
    }

    @Override
    public CreateUserReponse register(UserCreate user) {
        return authUseCase.register(user);
    }

    @Override
    public CreateUserReponse verifyauth(VerifyAuth user) {
        return authUseCase.verifyauth(user);
    }

    @Override
    public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
        return authUseCase.loadUserByEmail(email);
    }

    @Override
    public boolean existsByEmail(String email) {
        return authUseCase.existsByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}

package com.example.spring_demo.domain.port.in;

import com.example.spring_demo.domain.dto.in.Auth.VerifyAuth;
import com.example.spring_demo.domain.dto.in.User.UserCreate;
import com.example.spring_demo.domain.dto.out.CreateUserReponse;
import com.example.spring_demo.domain.model.UserModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface IAuthUseCase {
    CreateUserReponse login(String email, String password);
    CreateUserReponse register(UserCreate user);
    CreateUserReponse verifyauth(VerifyAuth user);

    UserDetails loadUserByEmail(String email) throws UsernameNotFoundException;
    boolean existsByEmail(@Email(message = "Vous devez entrer une adresse mail") @NotBlank(message = "L'adresse mail est obligatoire") String email);
}

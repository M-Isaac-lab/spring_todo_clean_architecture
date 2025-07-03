package com.example.spring_demo.domain.port.in;

import com.example.spring_demo.domain.dto.in.User.UserCreate;
import com.example.spring_demo.domain.dto.in.User.UserUpdate;
import com.example.spring_demo.domain.model.UserModel;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.UUID;

public interface IUserUseCase {
    UserModel findOneUser(UUID user_id);
    void createOneUser(UserCreate user);
    void updateUser(UserUpdate user);
    void deleteUser(UUID user_id);
    List<UserModel> findAllUser();

    UserDetails loadUserByEmail(String email) throws UsernameNotFoundException;
}

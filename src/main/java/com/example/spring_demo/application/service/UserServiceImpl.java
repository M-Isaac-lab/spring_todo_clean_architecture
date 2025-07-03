package com.example.spring_demo.application.service;

import com.example.spring_demo.domain.dto.in.User.UserCreate;
import com.example.spring_demo.domain.dto.in.User.UserUpdate;
import com.example.spring_demo.domain.dto.out.CreateUserReponse;
import com.example.spring_demo.domain.mapper.UserMapper;
import com.example.spring_demo.domain.model.UserModel;
import com.example.spring_demo.domain.port.in.IUserUseCase;
import com.example.spring_demo.domain.port.out.IUseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserUseCase, UserDetailsService {

    private final IUseRepository useRepository;
    private final UserMapper userMapper;


    @Override
    public UserModel findOneUser(UUID user_id) {
        return null;
    }

    @Override
    public void createOneUser(UserCreate user) {

    }

    @Override
    public void updateUser(UserUpdate user) {

    }

    @Override
    public void deleteUser(UUID user_id) {

    }

    @Override
    public List<UserModel> findAllUser() {
        return List.of();
    }

    @Override
    public UserDetails loadUserByEmail(String email)  {
        return useRepository.findByEmail(email);

    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return useRepository.findByEmail(username);
    }
}

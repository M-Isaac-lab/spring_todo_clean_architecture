package com.example.spring_demo.application.service;

import com.example.spring_demo.domain.dto.in.User.UserCreate;
import com.example.spring_demo.domain.dto.in.User.UserUpdate;
import com.example.spring_demo.domain.dto.out.CreateUserReponse;
import com.example.spring_demo.domain.mapper.UserMapper;
import com.example.spring_demo.domain.model.UserModel;
import com.example.spring_demo.domain.port.in.IUserUseCase;
import com.example.spring_demo.domain.port.out.IUseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserUseCase {

    private final IUseRepository useRepository;
    private final UserMapper userMapper;

    @Override
    public CreateUserReponse findOneUser(UUID user_id) {
        Optional<UserModel> userModel = useRepository.findById(user_id);
        return userMapper.userDto(userModel.get());
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
    public List<CreateUserReponse> findAllUser() {
        return List.of();
    }
}

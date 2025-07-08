package com.example.spring_demo.application.serviceImp;

import com.example.spring_demo.domain.dto.in.User.UserCreate;
import com.example.spring_demo.domain.dto.in.User.UserUpdate;
import com.example.spring_demo.domain.mapper.UserMapper;
import com.example.spring_demo.domain.model.UserModel;
import com.example.spring_demo.domain.port.in.IUserUseCase;
import com.example.spring_demo.domain.port.out.IUseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Repository("UserServiceImpl")
@RequiredArgsConstructor
public class UserServiceImpl implements IUserUseCase, UserDetailsService {

    private final IUseRepository useRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;



    @Override
    public UserModel findOneUser(UUID user_id) {
        return useRepository.findById(user_id).orElse(null);
    }

    @Override
    public void createOneUser(UserCreate user) {
        UserModel user_save = new UserModel();
        user_save.setFirstName(user.getFirstName());
        user_save.setLastName(user.getLastName());
        user_save.setYear(user.getYear());
        user_save.setEmail(user.getEmail());
        user_save.setPassword(passwordEncoder.encode(user.getPassword()));
        useRepository.save(user_save);
    }

    @Override
    public void updateUser(UserUpdate user) {
        findOneUser(user.getId());
        UserModel user_update = new UserModel();
        user_update.setId(user.getId());
        user_update.setFirstName(user.getFirstName());
        user_update.setLastName(user.getLastName());
        user_update.setYear(user.getYear());
        //user_update.setEmail(user.getEmail());
        user_update.setPassword(passwordEncoder.encode(user.getPassword()));
        useRepository.save(user_update);
    }

    @Override
    public void deleteUser(UUID user_id) {
        useRepository.deleteById(user_id);
    }

    @Override
    public List<UserModel> findAllUser() {
        List<UserModel> user_list = useRepository.findAll();
        return user_list;
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

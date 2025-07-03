package com.example.spring_demo.application.service;


import com.example.spring_demo.domain.model.UserModel;
import com.example.spring_demo.domain.port.in.IAuthUseCase;
import com.example.spring_demo.domain.port.out.IAuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthUseCase, UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final IAuthRepository authRepository;

    @Override
    public UserModel login(String email, String password) {
        UserModel user_login = new UserModel();
        user_login.setEmail(email);
        user_login.setPassword(password);
        UserModel account_valid = authRepository.findByEmail(user_login.getEmail());
        if(account_valid == null){ throw new IllegalArgumentException("Email or password incorrect");}
        String password_valid = account_valid.getPassword().hashCode()+"";
        if(!password_valid.equals(user_login.getPassword())){ throw new IllegalArgumentException("Email or password incorrect");}
        return account_valid;
    }

    @Override
    public void register(UserModel user) {
        String encode = passwordEncoder.encode(user.getPassword());
        UserModel user_save = new UserModel();
        user_save.setEmail(user.getEmail());
        user_save.setFirstName(user.getFirstName());
        user_save.setLastName(user.getLastName());
        user_save.setPassword(user.getPassword());
        authRepository.save(user_save);

        //user_save.
    }

    @Override
    public UserModel verifyauth(String otp, String user_id) {
        return null;
    }

    @Override
    public boolean existsByEmail(String email) {
        UserModel user =  authRepository.findByEmail(email);
        return user != null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return authRepository.findByEmail(username);
    }
}

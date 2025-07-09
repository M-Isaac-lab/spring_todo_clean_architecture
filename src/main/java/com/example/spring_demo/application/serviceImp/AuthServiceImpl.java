package com.example.spring_demo.application.serviceImp;



import com.example.spring_demo.domain.config.JwtUtils;
import com.example.spring_demo.domain.dto.in.Auth.VerifyAuth;
import com.example.spring_demo.domain.dto.in.User.UserCreate;
import com.example.spring_demo.domain.dto.out.CreateUserReponse;
import com.example.spring_demo.domain.mapper.UserMapper;
import com.example.spring_demo.domain.model.UserModel;
import com.example.spring_demo.domain.port.in.IAuthUseCase;
import com.example.spring_demo.domain.port.out.IAuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Repository("AuthServiceImpl")
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthUseCase, UserDetailsService {

    private final IAuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final UserMapper userMapper;


    @Override
    public CreateUserReponse login(String email, String password) {
        UserModel user_login = new UserModel();
        user_login.setEmail(email);
        user_login.setPassword(password);
        UserModel account_valid = authRepository.findByEmail(user_login.getEmail());
        if(account_valid == null){ throw new IllegalArgumentException("Email or password incorrect");}
        if(!passwordEncoder.matches(password, account_valid.getPassword())) {
            throw new IllegalArgumentException("Email ou mot de passe incorrect");
        }

        //if(user_login.getActivate() == false){
        //    throw new IllegalArgumentException("Acoount is not activate");
        //}

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password));
        String token = jwtUtils.generateJwtToken(email);
        account_valid.setToken(token);
        authRepository.save(account_valid);
        CreateUserReponse res = userMapper.userDto(account_valid);
        res.setToken(token);
        return res;
    }

    @Override
    public CreateUserReponse register(UserCreate user) {
        //String encode = passwordEncoder.encode(user.getPassword());
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        UserModel user_save = new UserModel();
        user_save.setEmail(user.getEmail());
        user_save.setFirstName(user.getFirstName());
        user_save.setYear(user.getYear());
        user_save.setLastName(user.getLastName());
        user_save.setPassword(hashedPassword);
        //user.setPassword(hashedPassword);

        authRepository.save(user_save);
        return login(user.getEmail(), user.getPassword());



        //user_save.
    }

    @Override
    public CreateUserReponse verifyauth(VerifyAuth user) {
        UserModel user_detail = authRepository.findById(user.getId())
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur non trouvé"));

        user_detail.setActivate(true);
        authRepository.save(user_detail);
        CreateUserReponse res = userMapper.userDto(user_detail);
        return res;
    }


    @Override
    public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
        return authRepository.findByEmail(email);
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

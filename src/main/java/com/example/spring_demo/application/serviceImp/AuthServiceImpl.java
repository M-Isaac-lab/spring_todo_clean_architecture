package com.example.spring_demo.application.serviceImp;



import com.example.spring_demo.domain.dto.in.User.UserCreate;
import com.example.spring_demo.domain.model.UserModel;
import com.example.spring_demo.domain.port.in.IAuthUseCase;
import com.example.spring_demo.domain.port.out.IAuthRepository;
import lombok.RequiredArgsConstructor;
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

    //private final PasswordEncoder passwordEncoder;
    private final IAuthRepository authRepository;
    //private final PasswordEncoder passwordEncoder;




    @Override
    public UserModel login(String email, String password) {
        UserModel user_login = new UserModel();
        user_login.setEmail(email);
        user_login.setPassword(password);
        UserModel account_valid = authRepository.findByEmail(user_login.getEmail());
        if(account_valid == null){ throw new IllegalArgumentException("Email or password incorrect");}
        String password_valid = account_valid.getPassword().hashCode()+"";
        //if(!passwordEncoder.matches(password, account_valid.getPassword())) {
       //     throw new IllegalArgumentException("Email ou mot de passe incorrect");
        //}
        return account_valid;
    }

    @Override
    public void register(UserCreate user) {
        //String encode = passwordEncoder.encode(user.getPassword());
        UserModel user_save = new UserModel();
        user_save.setEmail(user.getEmail());
        user_save.setFirstName(user.getFirstName());
        user_save.setYear(user.getYear());
        user_save.setLastName(user.getLastName());
        user_save.setPassword(user.getPassword());
        user.setPassword(user.getPassword());

        authRepository.save(user_save);



        //user_save.
    }

    @Override
    public UserModel verifyauth(String otp, String user_id) {
        UserModel user = authRepository.findById(UUID.fromString(user_id))
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur non trouvé"));

        user.setActivate(true);
        user.setToken("token_after_test");
        authRepository.save(user);

        return user;
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

package com.example.spring_demo.adapter.in;

import com.example.spring_demo.application.service.authService;
import com.example.spring_demo.domain.config.JwtAuthenticationFilter;
import com.example.spring_demo.domain.config.JwtUtils;
import com.example.spring_demo.domain.dto.in.Auth.Login;
import com.example.spring_demo.domain.dto.in.Auth.VerifyAuth;
import com.example.spring_demo.domain.dto.in.User.UserCreate;
import com.example.spring_demo.domain.dto.out.CreateUserReponse;
import com.example.spring_demo.domain.model.UserModel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final authService authService;
    private final JwtUtils jwtUtils;



    @PostMapping("/register")
    public CreateUserReponse register(@RequestBody UserCreate user) {
        //if (authService.existsByEmail(user.getEmail())) {
        //    return ResponseEntity.badRequest().body("Email already taken");
        //}
        return authService.register(user);
        //return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public CreateUserReponse login(@RequestBody Login user) {

            return authService.login(user.getEmail(), user.getPassword());

    }

    @PutMapping("/verifyauth")
    public CreateUserReponse verifyauth(@RequestBody VerifyAuth user) {
        return authService.verifyauth(user);
    }


    @GetMapping("/jwt")
    public String jwt() {
        return "hello";
    }


}

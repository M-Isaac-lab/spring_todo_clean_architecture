package com.example.spring_demo.adapter.in;

import com.example.spring_demo.application.service.authService;
import com.example.spring_demo.domain.config.JwtUtils;
import com.example.spring_demo.domain.dto.in.Auth.Login;
import com.example.spring_demo.domain.dto.in.User.UserCreate;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final authService authService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;



    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserCreate user) {
        if (authService.existsByEmail(user.getEmail())) {
            return ResponseEntity.badRequest().body("Email already taken");
        }
        authService.register(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Login user) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
            String token = jwtUtils.generateJwtToken(user.getEmail());
            authService.login(user.getEmail(), user.getPassword());
            return ResponseEntity.ok(token);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }


}

package com.example.spring_demo.adapter.in;

import com.example.spring_demo.application.service.authService;
import com.example.spring_demo.domain.config.JwtUtils;
import com.example.spring_demo.domain.model.UserModel;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final authService authService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;



    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserModel user) {
        if (authService.existsByEmail(user.getEmail())) {
            return ResponseEntity.badRequest().body("Email already taken");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        authService.register(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserModel user) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
            String token = jwtUtils.generateJwtToken(user.getEmail());
            return ResponseEntity.ok(token);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }
}

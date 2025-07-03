package com.example.spring_demo.domain.port.out;

import com.example.spring_demo.domain.model.UserModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IAuthRepository extends JpaRepository<UserModel, UUID> {
    UserModel findByEmail(String email);

    boolean existsByEmail(@Email(message = "Vous devez entrer une adresse mail") @NotBlank(message = "L'adresse mail est obligatoire") String email);
}

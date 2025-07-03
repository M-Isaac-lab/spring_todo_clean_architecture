package com.example.spring_demo.domain.port.out;

import com.example.spring_demo.domain.model.UserModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IUseRepository extends JpaRepository<UserModel, UUID> {
    UserModel findByUser_id(@NotNull(message = "L'identifiant de l'utilisateur est obligatoire") UUID userId);
    UserDetails findByEmail(String email);
    //boolean existsByEmail(@Email(message = "Vous devez entrer une adresse mail") @NotBlank(message = "L'adresse mail est obligatoire") String email);
}

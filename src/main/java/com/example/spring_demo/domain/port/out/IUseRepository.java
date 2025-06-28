package com.example.spring_demo.domain.port.out;

import com.example.spring_demo.domain.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IUseRepository extends JpaRepository<UserModel, UUID> {
}

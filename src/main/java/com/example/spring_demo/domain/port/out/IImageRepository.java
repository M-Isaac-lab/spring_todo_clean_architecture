package com.example.spring_demo.domain.port.out;

import com.example.spring_demo.domain.model.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IImageRepository extends JpaRepository<ImageModel, Number> {
}

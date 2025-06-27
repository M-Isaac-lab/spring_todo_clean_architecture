package com.example.spring_demo.domain.port.out;


import com.example.spring_demo.domain.model.TodoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITodoRepository extends JpaRepository<TodoModel, Long> {}

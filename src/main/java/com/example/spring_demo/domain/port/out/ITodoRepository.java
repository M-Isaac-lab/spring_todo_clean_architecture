package com.example.spring_demo.domain.port.out;


import com.example.spring_demo.domain.model.TodoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ITodoRepository extends JpaRepository<TodoModel, UUID> {
    List<TodoModel> findByUser_User_id(UUID userId);

    TodoModel findByTodo_id(UUID todoId);

    void deleteTodoModelByTodo_id(UUID todoId);
}

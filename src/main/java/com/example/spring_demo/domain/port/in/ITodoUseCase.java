package com.example.spring_demo.domain.port.in;

import com.example.spring_demo.domain.model.TodoModel;

import java.util.List;
import java.util.UUID;

public interface ITodoUseCase {
    TodoModel CreateTodo (TodoModel todo);
    List<TodoModel> getTodosByUser(UUID user_id);
    TodoModel getTodoById(UUID todo_id);
    void deleteTodo(UUID todo_id);
    void updateTodo(TodoModel todo);
    List<TodoModel> findallTodo ();
}

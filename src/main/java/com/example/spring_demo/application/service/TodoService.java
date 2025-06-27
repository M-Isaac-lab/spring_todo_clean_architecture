package com.example.spring_demo.application.service;

import com.example.spring_demo.domain.model.TodoModel;
import com.example.spring_demo.domain.port.in.ITodoUseCase;
import com.example.spring_demo.domain.port.out.ITodoRepository;

import java.util.List;
import java.util.UUID;

public class TodoService implements ITodoUseCase {

    private final ITodoRepository todoRepository;

    public TodoService(ITodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public TodoModel CreateTodo(TodoModel todo) {
        return todoRepository.save(todo);
    }

    @Override
    public List<TodoModel> getTodosByUser(UUID user_id) {
        return List.of();
    }

    @Override
    public TodoModel getTodoById(UUID todo_id) {
        return null;
    }

    @Override
    public void deleteTodo(UUID todo_id) {

    }

    @Override
    public void updateTodo(TodoModel todo) {

    }

    @Override
    public List<TodoModel> findallTodo() {
        return List.of();
    }
}

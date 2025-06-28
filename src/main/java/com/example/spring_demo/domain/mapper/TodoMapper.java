package com.example.spring_demo.domain.mapper;

import com.example.spring_demo.domain.dto.out.CreateTodoReponse;
import com.example.spring_demo.domain.model.TodoModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TodoMapper {
    public CreateTodoReponse toDto(TodoModel todo) {
        return new CreateTodoReponse(
            todo.getTodo_id(),
            todo.getTitle(),
            todo.getDescription(),
            todo.getCreatedAt(),
            todo.getUpdatedAt(),
            todo.getUser().getUser_id(),
            todo.getImages()
        );
    }

    public List<CreateTodoReponse> toDtoList(List<TodoModel> todos) {
        return todos.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
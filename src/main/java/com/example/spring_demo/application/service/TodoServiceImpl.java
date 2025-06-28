package com.example.spring_demo.application.service;

import com.example.spring_demo.domain.dto.in.Todo.TodoCreate;
import com.example.spring_demo.domain.dto.in.Todo.TodoUpdate;
import com.example.spring_demo.domain.dto.out.CreateTodoReponse;
import com.example.spring_demo.domain.mapper.TodoMapper;
import com.example.spring_demo.domain.model.TodoModel;
import com.example.spring_demo.domain.model.UserModel;
import com.example.spring_demo.domain.port.in.ITodoUseCase;
import com.example.spring_demo.domain.port.out.ITodoRepository;
import com.example.spring_demo.domain.port.out.IUseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements ITodoUseCase {

    private final ITodoRepository todoRepository;
    private final IUseRepository useRepository;
    private final TodoMapper todoMapper;

    @Override
    public CreateTodoReponse CreateTodo(TodoCreate todo) {
        UserModel user = useRepository.findById(todo.getUser_id())
                .orElseThrow(() -> new EntityNotFoundException("Utilisateur introuvable"));

        TodoModel todoModel = new TodoModel();
        todoModel.setTitle(todo.getTitle());
        todoModel.setDescription(todo.getDescription());
        todoModel.setUser(user); // l'entité, pas juste l'UUID

        TodoModel savedTodo = todoRepository.save(todoModel);
        return todoMapper.toDto(savedTodo);

    }

    @Override
    public List<CreateTodoReponse> getTodosByUser(UUID user_id) {
        return List.of();
    }

    @Override
    public CreateTodoReponse getTodoById(UUID todo_id) {
        return null;
    }

    @Override
    public void deleteTodo(UUID todo_id) {

    }

    @Override
    public void updateTodo(TodoUpdate todo) {

    }

    @Override
    public List<CreateTodoReponse> findallTodo() {
        return List.of();
    }
}
package com.example.spring_demo.application.serviceImp;

import com.example.spring_demo.domain.dto.in.Todo.TodoCreate;
import com.example.spring_demo.domain.dto.in.Todo.TodoUpdate;
import com.example.spring_demo.domain.mapper.TodoMapper;
import com.example.spring_demo.domain.model.TodoModel;
import com.example.spring_demo.domain.model.UserModel;
import com.example.spring_demo.domain.port.in.ITodoUseCase;
import com.example.spring_demo.domain.port.out.ITodoRepository;
import com.example.spring_demo.domain.port.out.IUseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Repository("TodoServiceImpl")
@RequiredArgsConstructor
public class TodoServiceImpl implements ITodoUseCase {

    private final ITodoRepository todoRepository;
    private final IUseRepository useRepository;
    private final TodoMapper todoMapper;
    private final UserServiceImpl userService;


    @Override
    public TodoModel CreateTodo(TodoCreate todo) {
        UserModel user = userService.findOneUser(todo.getUser_id());
        if(user == null){ throw new EntityNotFoundException("User not found");}
        TodoModel todo_save = new TodoModel();
        todo_save.setTitle(todo.getTitle());
        todo_save.setDescription(todo.getDescription());
        todo_save.setUser(user);
        return todoRepository.save(todo_save);
    }

    @Override
    public List<TodoModel> getTodosByUser(UUID user_id) {
        return todoRepository.findByUserId(user_id);
    }

    @Override
    public TodoModel getTodoById(UUID todo_id) {
        return todoRepository.findById(todo_id).orElse(null);
    }

    @Override
    public void deleteTodo(UUID todo_id) {
        todoRepository.deleteById(todo_id);
    }

    @Override
    public void updateTodo(TodoUpdate todo) {
        UserModel user = userService.findOneUser(todo.getUser_id());
        if(user == null){ throw new EntityNotFoundException("User not found");}
        TodoModel todo_update = new TodoModel();
        todo_update.setId(todo.getId());
        todo_update.setTitle(todo.getTitle());
        todo_update.setDescription(todo.getDescription());
        todo_update.setUser(user);
        todoRepository.save(todo_update);
    }

    @Override
    public List<TodoModel> findallTodo() {
        return todoRepository.findAll();
    }
}
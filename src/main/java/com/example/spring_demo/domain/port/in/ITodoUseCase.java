package com.example.spring_demo.domain.port.in;

import com.example.spring_demo.domain.dto.in.Todo.TodoCreate;
import com.example.spring_demo.domain.dto.in.Todo.TodoUpdate;
import com.example.spring_demo.domain.dto.out.CreateTodoReponse;
import com.example.spring_demo.domain.model.TodoModel;

import java.util.List;
import java.util.UUID;

public interface ITodoUseCase {
    CreateTodoReponse CreateTodo (TodoCreate todo);
    List<CreateTodoReponse> getTodosByUser(UUID user_id);
    CreateTodoReponse getTodoById(UUID todo_id);
    void deleteTodo(UUID todo_id);
    void updateTodo(TodoUpdate todo);
    List<CreateTodoReponse> findallTodo ();
}

package com.challenge.todo.service.impl;

import com.challenge.todo.converters.FolderConverter;
import com.challenge.todo.dto.RequestTodoDTO;
import com.challenge.todo.models.Todo;
import com.challenge.todo.repositories.TodoRespository;
import com.challenge.todo.service.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService implements ITodoService {
    @Autowired
    private TodoRespository todoRespository;

    @Override
    public void createTodo(RequestTodoDTO requestTodoDTO) {
        todoRespository.save(FolderConverter.requestTodoToTodo(requestTodoDTO));
    }

    @Override
    public void updateTodo(RequestTodoDTO requestTodoDTO, Long id) {
        Todo todo = todoRespository.getById(id);
        todo.setName(requestTodoDTO.getName());
        todoRespository.save(todo);
    }

    @Override
    public void deleteTodo(Long id) {
        todoRespository.deleteById(id);
    }

    @Override
    public void completeTodo(Long id) {
        Todo todo = todoRespository.getById(id);
        todo.setCompleted(!todo.isCompleted());
        todoRespository.save(todo);
    }
}

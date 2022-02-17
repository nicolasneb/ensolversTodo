package com.challenge.todo.service;

import com.challenge.todo.dto.RequestTodoDTO;

public interface ITodoService {
    void createTodo(RequestTodoDTO requestTodoDTO);
    void updateTodo(RequestTodoDTO requestTodoDTO, Long id);
    void deleteTodo(Long id);
    void completeTodo(Long id);
}

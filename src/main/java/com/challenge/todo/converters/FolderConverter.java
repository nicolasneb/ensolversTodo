package com.challenge.todo.converters;

import com.challenge.todo.dto.FolderDTO;
import com.challenge.todo.dto.RequestFolderDTO;
import com.challenge.todo.dto.RequestTodoDTO;
import com.challenge.todo.dto.TodoDTO;
import com.challenge.todo.models.Folder;
import com.challenge.todo.models.Todo;

import java.util.ArrayList;
import java.util.List;

public final class FolderConverter {
    public static FolderDTO folderToFolderDTO(Folder folder){
        FolderDTO folderDTO = new FolderDTO();
        folderDTO.setId(folder.getId());
        folderDTO.setName(folder.getName());
        folderDTO.setTodos(todoToTodoDTO(folder.getTodos()));

        return folderDTO;
    };

    public static List<TodoDTO> todoToTodoDTO(List<Todo> todos){
        List<TodoDTO> todosDTO = new ArrayList<>();
        for(Todo t : todos){
            TodoDTO todoDTO = new TodoDTO();
            todoDTO.setId(t.getId());
            todoDTO.setCompleted(t.isCompleted());
            todoDTO.setName(t.getName());
            todosDTO.add(todoDTO);
        }
        return todosDTO;
    }

    public static Folder requestFolderToFolder(RequestFolderDTO requestFolderDTO){
        Folder folder = new Folder();
        folder.setName(requestFolderDTO.getName());
        return folder;
    }

    public static Todo requestTodoToTodo(RequestTodoDTO requestTodoDTO){
        Todo todo = new Todo();
        todo.setName(requestTodoDTO.getName());
        todo.setCompleted(false);
        return todo;
    }
}

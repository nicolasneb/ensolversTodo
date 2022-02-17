package com.challenge.todo.service;

import com.challenge.todo.dto.FolderDTO;
import com.challenge.todo.dto.RequestFolderDTO;
import com.challenge.todo.dto.RequestTodoDTO;

import java.util.List;

public interface IFolderService {
    List<FolderDTO> getFolders();
    FolderDTO getFolder(Long id);
    void createFolder(RequestFolderDTO requestFolderDTO);
    void updateFolder(RequestFolderDTO requestFolderDTO, Long id);
    void deleteFolder(Long id);
    void addTodo(RequestTodoDTO requestTodoDTO, Long id);
    void deleteTodo(Long idFolder, Long idTodo);
}

package com.challenge.todo.service.impl;

import com.challenge.todo.converters.FolderConverter;
import com.challenge.todo.dto.FolderDTO;
import com.challenge.todo.dto.RequestFolderDTO;
import com.challenge.todo.dto.RequestTodoDTO;
import com.challenge.todo.models.Folder;
import com.challenge.todo.models.Todo;
import com.challenge.todo.repositories.FolderRepository;
import com.challenge.todo.service.IFolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FolderService implements IFolderService {
    @Autowired
    private FolderRepository folderRepository;

    @Override
    public List<FolderDTO> getFolders() {
        List<FolderDTO> foldersDTO = new ArrayList<>();
        List<Folder> folders = folderRepository.findAll();

        for(Folder f : folders){
            foldersDTO.add(FolderConverter.folderToFolderDTO(f));
        }

        return foldersDTO;
    }

    @Override
    public FolderDTO getFolder(Long id) {
        return FolderConverter.folderToFolderDTO(folderRepository.getById(id));
    }

    @Override
    public void createFolder(RequestFolderDTO requestFolderDTO) {
        folderRepository.save(FolderConverter.requestFolderToFolder(requestFolderDTO));
    }

    @Override
    public void updateFolder(RequestFolderDTO requestFolderDTO, Long id) {
        Folder folder = folderRepository.getById(id);
        folder.setName(requestFolderDTO.getName());
        folderRepository.save(folder);
    }

    @Override
    public void deleteFolder(Long id) {
        folderRepository.deleteById(id);
    }

    @Override
    public void addTodo(RequestTodoDTO requestTodoDTO, Long id) {
        Folder folder = folderRepository.getById(id);
        folder.getTodos().add(FolderConverter.requestTodoToTodo(requestTodoDTO));
        folderRepository.save(folder);
    }

    @Override
    public void deleteTodo(Long idFolder, Long idTodo) {
        Folder folder = folderRepository.getById(idFolder);
        List<Todo> todos = folder.getTodos();
        List<Todo> newTodos = new ArrayList<>();
        for(Todo t : todos){
            if(t.getId() != idTodo){
                newTodos.add(t);
            }
        }
        folder.setTodos(newTodos);
        folderRepository.save(folder);
    }

}

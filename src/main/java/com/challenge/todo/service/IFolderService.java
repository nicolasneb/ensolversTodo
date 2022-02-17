package com.challenge.todo.service;

import com.challenge.todo.dto.FolderDTO;
import com.challenge.todo.dto.RequestFolderDTO;

import java.util.List;

public interface IFolderService {
    List<FolderDTO> getFolders();
    void createFolder(RequestFolderDTO requestFolderDTO);
    void updateFolder(RequestFolderDTO requestFolderDTO, Long id);
    void deleteFolder(Long id);
}

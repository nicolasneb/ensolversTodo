package com.challenge.todo.service;

import com.challenge.todo.dto.FolderDTO;

import java.util.List;

public interface IFolderService {
    List<FolderDTO> getFolders();
}

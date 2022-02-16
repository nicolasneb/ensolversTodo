package com.challenge.todo.service.impl;

import com.challenge.todo.converters.FolderConverter;
import com.challenge.todo.dto.FolderDTO;
import com.challenge.todo.models.Folder;
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
}

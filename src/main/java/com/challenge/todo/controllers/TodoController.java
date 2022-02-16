package com.challenge.todo.controllers;

import com.challenge.todo.dto.FolderDTO;
import com.challenge.todo.service.IFolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/folders")
public class TodoController {
    @Autowired
    IFolderService folderService;

    @GetMapping
    public List<FolderDTO> getFolders(){
        return folderService.getFolders();
    }
}

package com.challenge.todo.controllers;

import com.challenge.todo.dto.FolderDTO;
import com.challenge.todo.dto.RequestFolderDTO;
import com.challenge.todo.service.IFolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/folders")
@CrossOrigin(origins = {"*"}, maxAge = 3600)
public class TodoController {
    @Autowired
    IFolderService folderService;

    @GetMapping
    public List<FolderDTO> getFolders(){
        return folderService.getFolders();
    }

    @PostMapping
    public String createFolder(@RequestBody RequestFolderDTO requestFolderDTO){
        folderService.createFolder(requestFolderDTO);
        return "Folder created successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteFolder(@PathVariable("id") Long id){
        folderService.deleteFolder(id);
        return "Folder deleted successfully";
    }

    @PutMapping("/{id}")
    public String updateFolder(@PathVariable("id") Long id, @RequestBody RequestFolderDTO requestFolderDTO){
        folderService.updateFolder(requestFolderDTO, id);
        return "Folder updated successfully";
    }

}

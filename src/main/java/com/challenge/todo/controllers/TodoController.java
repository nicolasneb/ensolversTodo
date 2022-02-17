package com.challenge.todo.controllers;

import com.challenge.todo.dto.FolderDTO;
import com.challenge.todo.dto.RequestFolderDTO;
import com.challenge.todo.dto.RequestTodoDTO;
import com.challenge.todo.service.IFolderService;
import com.challenge.todo.service.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/folders")
@CrossOrigin(origins = {"*"}, maxAge = 3600)
public class TodoController {
    @Autowired
    IFolderService folderService;

    @Autowired
    ITodoService todoService;

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

    @GetMapping("/{id}")
    public FolderDTO getFolder(@PathVariable("id") Long id){
        return folderService.getFolder(id);
    }

    @PostMapping("/{id}/todos")
    public String createTodo(@PathVariable("id") Long id, @RequestBody RequestTodoDTO requestTodoDTO){
        folderService.addTodo(requestTodoDTO, id);
        return "To do created successfully";
    }

    @DeleteMapping("/{idFolder}/todos/{idTodo}")
    public String deleteTodo(@PathVariable("idFolder") Long idFolder, @PathVariable("idTodo") Long idTodo){
        folderService.deleteTodo(idFolder, idTodo);
        todoService.deleteTodo(idTodo);
        return "To do deleted successfully";
    }

    @PutMapping("/{idFolder}/todos/{idTodo}")
    public String updateTodo(@PathVariable("idFolder") Long idFolder, @PathVariable("idTodo") Long idTodo, @RequestBody RequestTodoDTO requestTodoDTO){
        todoService.updateTodo(requestTodoDTO, idTodo);
        return "To do updated successfully";
    }

    @PutMapping("/{idFolder}/todos/{idTodo}/complete")
    public String completeTodo(@PathVariable("idFolder") Long idFolder, @PathVariable("idTodo") Long idTodo){
        todoService.completeTodo(idTodo);
        return "To do updated successfully";
    }
}

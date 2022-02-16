package com.challenge.todo.dto;

import com.challenge.todo.models.Todo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class FolderDTO {
    private long id;
    private List<TodoDTO> todos;
}

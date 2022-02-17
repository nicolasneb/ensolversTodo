package com.challenge.todo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TodoDTO {
    private long id;
    private String name;
    private boolean completed;
}

package com.challenge.todo.repositories;

import com.challenge.todo.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TodoRespository extends JpaRepository<Todo, Long> {
}

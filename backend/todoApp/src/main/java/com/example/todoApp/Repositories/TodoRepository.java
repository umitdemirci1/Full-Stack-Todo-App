package com.example.todoApp.Repositories;

import com.example.todoApp.Entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}

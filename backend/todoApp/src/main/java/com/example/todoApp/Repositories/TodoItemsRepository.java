package com.example.todoApp.Repositories;

import com.example.todoApp.Entities.TodoItems;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TodoItemsRepository extends JpaRepository<TodoItems, Long> {
    List<TodoItems> findByTodoId(Optional<Long> todoId);
}

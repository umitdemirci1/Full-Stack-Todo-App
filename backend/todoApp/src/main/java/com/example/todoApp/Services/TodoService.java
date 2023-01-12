package com.example.todoApp.Services;

import com.example.todoApp.Entities.Todo;
import com.example.todoApp.Repositories.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
  private TodoRepository todoRepository;

  public TodoService(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  public List<Todo> getTodos() {
    return todoRepository.findAll();
  }

  public Todo getTodo(Long todoId) {
    return todoRepository.findById(todoId).orElse(null);
  }

  public Todo saveTodo(Todo newTodo) {
    return todoRepository.save(newTodo);
  }

  public Todo updateTodo(Todo updateTodo, Long todoId) {
    Optional<Todo> checkTodo = todoRepository.findById(todoId);
    if (checkTodo.isPresent()) {
      Todo saveTodo = checkTodo.get();
      saveTodo.setName(updateTodo.getName());
      saveTodo.setDescription(updateTodo.getDescription());
      todoRepository.save(saveTodo);
      return saveTodo;
    } else {
      return null;
    }
  }

  public void deleteTodo(Long todoId) {
    todoRepository.deleteById(todoId);
  }
}

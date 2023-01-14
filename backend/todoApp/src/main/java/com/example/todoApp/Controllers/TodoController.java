package com.example.todoApp.Controllers;

import com.example.todoApp.Entities.Todo;
import com.example.todoApp.Services.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@CrossOrigin(origins = "http://localhost:5173")
public class TodoController {

  private TodoService todoService;

  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  @GetMapping
  public List<Todo> getTodos(){
      return todoService.getTodos();
  }

  @GetMapping("/{todoId}")
  public Todo getTodo(@PathVariable Long todoId){
    return todoService.getTodo(todoId);
  }

  @PostMapping
  public Todo createTodo(@RequestBody Todo newTodo){
    return todoService.saveTodo(newTodo);
  }

  @PutMapping("/{todoId}")
  public Todo updateTodo(@RequestBody Todo updateTodo, @PathVariable Long todoId){
    return todoService.updateTodo(updateTodo, todoId);
  }

  @DeleteMapping("/{todoId}")
  public void deleteTodo(@PathVariable Long todoId){
    todoService.deleteTodo(todoId);
  }
}

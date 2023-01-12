package com.example.todoApp.Controllers;

import com.example.todoApp.Entities.TodoItems;
import com.example.todoApp.Requests.TodoItemsUpdateRequest;
import com.example.todoApp.Responses.TodoItemsResponse;
import com.example.todoApp.Services.TodoItemsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todoItems")
public class TodoItemsController {

  private TodoItemsService todoItemsService;

  public TodoItemsController(TodoItemsService todoItemsService) {
    this.todoItemsService = todoItemsService;
  }

  @GetMapping
  public List<TodoItemsResponse> getTodoItems(Optional<Long> todoId) {
    return todoItemsService.getTodoItems(todoId);
  }

  @GetMapping("/{todoItemsId}")
  public TodoItems getOneTodoItem(@PathVariable Long todoItemsId) {
    return todoItemsService.getOneTodoItem(todoItemsId);
  }

  @PostMapping("/{todoItemsId}")
  public TodoItems saveTodoItem(@RequestBody TodoItems newItem) {
    return todoItemsService.saveTodoItem(newItem);
  }

  @PutMapping("/{todoItemsId}")
  public TodoItems updateTodoItem(@RequestBody TodoItemsUpdateRequest updateItem, @PathVariable Long todoItems) {
    return todoItemsService.updateTodoItem(updateItem, todoItems);
  }

  @DeleteMapping("/{todoItemsId}")
  public void deleteTodoItem(@PathVariable Long todoItems) {
    todoItemsService.deleteTodoItem(todoItems);
  }
}

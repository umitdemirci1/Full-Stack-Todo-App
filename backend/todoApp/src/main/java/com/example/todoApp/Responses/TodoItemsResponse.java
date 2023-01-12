package com.example.todoApp.Responses;

import com.example.todoApp.Entities.TodoItems;
import lombok.Data;

@Data
public class TodoItemsResponse {
  private Long id;
  private Long todoId;
  private String todoItem;

  public TodoItemsResponse(TodoItems entity) {
    this.id = entity.getId();
    this.todoId = entity.getTodo().getId();
    this.todoItem = entity.getTodoItem();
  }
}

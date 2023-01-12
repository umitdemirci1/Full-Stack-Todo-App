package com.example.todoApp.Requests;

import lombok.Data;

@Data
public class TodoItemsCreateRequest {

  private Long id;
  private Long todoId;
  private String todoItem;
}

package com.example.todoApp.Services;

import com.example.todoApp.Entities.TodoItems;
import com.example.todoApp.Repositories.TodoItemsRepository;
import com.example.todoApp.Requests.TodoItemsUpdateRequest;
import com.example.todoApp.Responses.TodoItemsResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoItemsService {

  private TodoItemsRepository todoItemsRepository;

  public TodoItemsService(TodoItemsRepository todoItemsRepository) {
    this.todoItemsRepository = todoItemsRepository;
  }

  public List<TodoItemsResponse> getTodoItems(Optional<Long> todoId) {
    List<TodoItems> list;
    if (todoId.isPresent()) {
      list = todoItemsRepository.findByTodoId(todoId);
    } else {
      list = todoItemsRepository.findAll();
    }
    return list.stream().map(p -> new TodoItemsResponse(p)).collect(Collectors.toList());
  }

  public TodoItems getOneTodoItem(Long todoItemsId) {
    return todoItemsRepository.findById(todoItemsId).orElse(null);
  }

  public TodoItems saveTodoItem(TodoItems newItem) {
    return todoItemsRepository.save(newItem);
  }

  public TodoItems updateTodoItem(TodoItemsUpdateRequest updateItem, Long todoItems) {
    Optional<TodoItems> checkTodoItem = todoItemsRepository.findById(todoItems);
    if (checkTodoItem.isPresent()) {
      TodoItems saveTodoItem = checkTodoItem.get();
      saveTodoItem.setTodoItem(updateItem.getTodoItem());
      return saveTodoItem;
    } else return null;
  }

  public void deleteTodoItem(Long todoItems) {
    todoItemsRepository.deleteById(todoItems);
  }
}

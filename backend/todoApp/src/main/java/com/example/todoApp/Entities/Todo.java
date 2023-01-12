package com.example.todoApp.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "todo")
@Data
public class Todo {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Long id;

  private String name;

  @Lob
  @Column(columnDefinition = "text")
  private String description;
}

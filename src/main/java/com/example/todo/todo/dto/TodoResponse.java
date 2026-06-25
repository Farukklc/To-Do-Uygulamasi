package com.example.todo.todo.dto;

import lombok.Data;

@Data
public class TodoResponse {
    private Long id;
    private String title;
    private Boolean completed;
}

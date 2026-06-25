package com.example.todo.todo.exception;

public class TodoNotFoundException extends RuntimeException {
    public TodoNotFoundException(Long id) {
        super("Todo bulunamadı. ID: " + id);
    }
}

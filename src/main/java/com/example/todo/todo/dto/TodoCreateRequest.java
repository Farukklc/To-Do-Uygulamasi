package com.example.todo.todo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TodoCreateRequest {
    @NotBlank(message = "Title alanı boş bırakılamaz")
    @Size(min = 2, max = 100, message = "Title 2 ile 100 karakter arasında olmalıdır")
    private String title;
}

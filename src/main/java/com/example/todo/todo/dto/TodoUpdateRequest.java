package com.example.todo.todo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TodoUpdateRequest {
    @NotBlank(message = "Title alanı boş bırakılamaz")
    @Size(min = 2, max = 100, message = "Title 2 ile 100 karakter arasında olmalıdır")
    private String title;

    @NotNull(message = "Completed durumu belirtilmelidir")
    private Boolean completed;
}

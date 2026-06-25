package com.example.todo.todo.mapper;

import com.example.todo.todo.dto.TodoCreateRequest;
import com.example.todo.todo.dto.TodoResponse;
import com.example.todo.todo.dto.TodoUpdateRequest;
import com.example.todo.todo.entity.Todo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    Todo toEntity(TodoCreateRequest request);
    void updateEntity(@MappingTarget Todo entity, TodoUpdateRequest request);
    TodoResponse toResponse(Todo entity);
    List<TodoResponse> toResponseList(List<Todo> entityList);
}

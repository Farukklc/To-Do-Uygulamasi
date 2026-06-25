package com.example.todo.todo.service;

import com.example.todo.todo.dto.TodoCreateRequest;
import com.example.todo.todo.dto.TodoResponse;
import com.example.todo.todo.dto.TodoUpdateRequest;
import com.example.todo.todo.entity.Todo;
import com.example.todo.todo.exception.TodoNotFoundException;
import com.example.todo.todo.mapper.TodoMapper;
import com.example.todo.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository repository;
    private final TodoMapper mapper;

    public List<TodoResponse> getAll() {
        return mapper.toResponseList(repository.findAll());
    }

    public TodoResponse getById(Long id) {
        Todo todo = repository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));
        return mapper.toResponse(todo);
    }

    public TodoResponse create(TodoCreateRequest request) {
        Todo entity = mapper.toEntity(request);
        Todo savedEntity = repository.save(entity);
        return mapper.toResponse(savedEntity);
    }

    public TodoResponse update(Long id, TodoUpdateRequest request) {
        Todo existing = repository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));

        mapper.updateEntity(existing, request);

        Todo updatedEntity = repository.save(existing);
        return mapper.toResponse(updatedEntity);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new TodoNotFoundException(id);
        }
        repository.deleteById(id);
    }
}

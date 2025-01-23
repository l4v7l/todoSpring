package ru.l4v7l.todospring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.l4v7l.todospring.dto.TaskDto;
import ru.l4v7l.todospring.service.TaskService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tasks")
public class TaskController {
    private final TaskService service;

    @PutMapping
    public TaskDto create(@RequestBody TaskDto task) {
        return service.create(task);
    }

    @GetMapping("/{id}")
    public TaskDto get(@PathVariable Long id) {
        return service.get(id);
    }

    @PatchMapping("/{id}")
    public TaskDto update(@PathVariable Long id, @RequestBody TaskDto task) {
        return service.update(id, task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

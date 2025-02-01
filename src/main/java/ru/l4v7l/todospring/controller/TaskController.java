package ru.l4v7l.todospring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.l4v7l.todospring.dto.TaskDto;
import ru.l4v7l.todospring.entity.Task;
import ru.l4v7l.todospring.service.TaskService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tasks")
public class TaskController {
    private final TaskService service;

    @PostMapping
    public String create(@RequestBody TaskDto taskDto) {
        return service.create(taskDto);
    }

    @GetMapping("/{id}")
    public TaskDto get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping("")
    public List<TaskDto> getAllTasks() {
        return service.getAllTasks();
    }

    @GetMapping("/{status}")
    public List<TaskDto> getAllTasksByStatus(@PathVariable String status) {
        return service.getAllTasksByStatus(status);
    }

    @GetMapping("/sorted-by-status")
    public List<TaskDto> getAllTasksSortedByStatus() {
        return service.getAllTasksSortedByStatus();
    }

    @GetMapping("/sorted-by-date")
    public List<TaskDto> getAllTasksSortedByDueDate() {
        return service.getAllTasksSortedByDueDate();
    }

    @PatchMapping("/{id}/update")
    public String update(@RequestBody Task task) {
        return service.update(task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

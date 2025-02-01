package ru.l4v7l.todospring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.l4v7l.todospring.dto.TaskDto;
import ru.l4v7l.todospring.dto.UserDto;
import ru.l4v7l.todospring.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService service;

    @PostMapping
    public String create(@RequestBody UserDto user) {
        return service.create(user);
    }

    @GetMapping("/{id}")
    public UserDto get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping("/{id}/tasks")
    public List<TaskDto> getAllTasks(@PathVariable Long id) {
        return service.getAllTasks(id);
    }

    @PatchMapping("/update")
    public String update(@RequestBody UserDto user) {
        return service.update(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

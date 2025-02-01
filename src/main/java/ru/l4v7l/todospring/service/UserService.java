package ru.l4v7l.todospring.service;

import ru.l4v7l.todospring.dto.TaskDto;
import ru.l4v7l.todospring.dto.UserDto;

import java.util.List;

public interface UserService {

    String create(UserDto user);

    UserDto get(Long id);

    List<TaskDto> getAllTasks(Long id);

    String update(UserDto user);

    void delete(Long id);
}

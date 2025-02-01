package ru.l4v7l.todospring.service;

import ru.l4v7l.todospring.dto.TaskDto;
import ru.l4v7l.todospring.entity.Task;

import java.util.List;

public interface TaskService {

    String create(TaskDto taskDto);

    TaskDto get(Long id);

    List<TaskDto> getAllTasks();

    List<TaskDto> getAllTasksByStatus(String status);

    List<TaskDto> getAllTasksSortedByStatus();

    List<TaskDto> getAllTasksSortedByDueDate();

    String update(Task task);

    void delete(Long id);
}

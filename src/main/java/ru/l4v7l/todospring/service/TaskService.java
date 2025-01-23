package ru.l4v7l.todospring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.l4v7l.todospring.dto.TaskDto;
import ru.l4v7l.todospring.repository.TaskRepository;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository repository;

    public TaskDto create(TaskDto task) {
        return repository.create(task);
    }

    public TaskDto get(Long id) {
        return repository.get(id);
    }

    public TaskDto update(Long id, TaskDto task) {
        return repository.update(id, task);
    }

    public void delete(Long id) {
        repository.delete(id);
    }
}

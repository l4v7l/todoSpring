package ru.l4v7l.todospring.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.l4v7l.todospring.dto.TaskDto;
import ru.l4v7l.todospring.entity.Task;
import ru.l4v7l.todospring.enume.TaskStatus;
import ru.l4v7l.todospring.mapper.Mapper;
import ru.l4v7l.todospring.repository.TaskRepository;
import ru.l4v7l.todospring.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceDB implements ru.l4v7l.todospring.service.TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public String create(TaskDto taskDto) {
        Task task = Mapper.mapDtoToTask(taskDto);

        if (taskDto.getAuthor() != null) {
            task.setAuthor(userRepository.findById(taskDto.getAuthor()).orElse(null));
        }

        taskRepository.save(task);
        return "Success";
    }

    public TaskDto get(Long id) {
        return taskRepository.findById(id).map(Mapper::mapTaskToDto).orElse(null);
    }

    public List<TaskDto> getAllTasks() {
        return taskRepository.findAll().stream().map(Mapper::mapTaskToDto).collect(Collectors.toList());
    }

    public List<TaskDto> getAllTasksByStatus(String status) {
        return taskRepository.findAllByStatus(TaskStatus.valueOf(status)).stream().map(Mapper::mapTaskToDto).collect(Collectors.toList());
    }

    public List<TaskDto> getAllTasksSortedByStatus() {
        return taskRepository.findAllByOrderByStatus().stream().map(Mapper::mapTaskToDto).collect(Collectors.toList());
    }

    public List<TaskDto> getAllTasksSortedByDueDate() {
        return taskRepository.findAllByOrderByDueDate().stream().map(Mapper::mapTaskToDto).collect(Collectors.toList());
    }

    public String update(Task task) {
        taskRepository.save(task);
        return "Success";
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}

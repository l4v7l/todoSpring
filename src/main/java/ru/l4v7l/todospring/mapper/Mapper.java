package ru.l4v7l.todospring.mapper;

import ru.l4v7l.todospring.dto.TaskDto;
import ru.l4v7l.todospring.dto.UserDto;
import ru.l4v7l.todospring.entity.Task;
import ru.l4v7l.todospring.entity.User;
import ru.l4v7l.todospring.enume.TaskStatus;

import java.util.stream.Collectors;

public class Mapper {

    public static User mapDtoToUser(UserDto dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setTasks(dto.getTasks() == null ? null : dto.getTasks().stream().map(Mapper::mapDtoToTask).collect(Collectors.toList()));

        return user;
    }

    public static UserDto mapUserToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setTasks(user.getTasks() == null ? null : user.getTasks().stream().map(Mapper::mapTaskToDto).collect(Collectors.toList()));

        return userDto;
    }

    public static Task mapDtoToTask(TaskDto dto) {
        Task task = new Task();
        task.setId(dto.getId());
        task.setAuthor(null);
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus(TaskStatus.valueOf(dto.getStatus()));
        task.setDueDate(dto.getDueDate());

        return task;
    }

    public static TaskDto mapTaskToDto(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setAuthor(task.getAuthor() == null ? null : task.getAuthor().getId());
        taskDto.setTitle(task.getTitle());
        taskDto.setDescription(task.getDescription());
        taskDto.setStatus(task.getStatus().getValue());
        taskDto.setDueDate(task.getDueDate());

        return taskDto;
    }


}

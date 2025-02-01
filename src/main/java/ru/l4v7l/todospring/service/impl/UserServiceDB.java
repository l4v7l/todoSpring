package ru.l4v7l.todospring.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.l4v7l.todospring.dto.TaskDto;
import ru.l4v7l.todospring.dto.UserDto;
import ru.l4v7l.todospring.mapper.Mapper;
import ru.l4v7l.todospring.repository.TaskRepository;
import ru.l4v7l.todospring.repository.UserRepository;
import ru.l4v7l.todospring.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceDB implements UserService {

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;


    @Override
    public String create(UserDto user) {
        userRepository.save(Mapper.mapDtoToUser(user));
        return "Success";
    }

    @Override
    public UserDto get(Long id) {
        return userRepository.findById(id).map(Mapper::mapUserToDto).orElse(null);
    }

    @Override
    public List<TaskDto> getAllTasks(Long id) {
        return taskRepository.findAllByAuthor_Id(id).stream().map(Mapper::mapTaskToDto).collect(Collectors.toList());
    }

    @Override
    public String update(UserDto user) {
        userRepository.save(Mapper.mapDtoToUser(user));
        return "Success";
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}

package ru.l4v7l.todospring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.l4v7l.todospring.dto.UserDto;
import ru.l4v7l.todospring.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public UserDto create(UserDto user) {
        return repository.create(user);
    }

    public UserDto get(Long id) {
        return repository.get(id);
    }

    public UserDto update(Long id, UserDto user) {
        return repository.update(id, user);
    }

    public void delete(Long id) {
        repository.delete(id);
    }
}

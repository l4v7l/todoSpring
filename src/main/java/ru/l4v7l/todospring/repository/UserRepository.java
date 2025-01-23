package ru.l4v7l.todospring.repository;

import org.springframework.stereotype.Repository;
import ru.l4v7l.todospring.dto.UserDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class UserRepository {

    //TEMP
    private final List<UserDto> list = new ArrayList<>();

    public UserDto create(UserDto user) {
        list.add(user);
        return user;
    }

    public UserDto get(Long id) {
        return list.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);
    }

    public UserDto update(Long id, UserDto user) {
        int index = IntStream.range(0, list.size()).filter(i -> list.get(i).getId().equals(id)).findFirst().orElse(-1);

        if (index == -1) {
            return null;
        }

        list.set(index, user);

        return user;
    }

    public void delete(Long id) {
        list.remove(list.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null));
    }
}

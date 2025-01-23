package ru.l4v7l.todospring.repository;

import org.springframework.stereotype.Repository;
import ru.l4v7l.todospring.dto.TaskDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class TaskRepository {

    //TEMP
    private final List<TaskDto> list = new ArrayList<>();

    public TaskDto create(TaskDto task) {
        list.add(task);
        return task;
    }

    public TaskDto get(Long id) {
        return list.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);
    }

    public TaskDto update(Long id, TaskDto task) {
        int index = IntStream.range(0, list.size()).filter(i -> list.get(i).getId().equals(id)).findFirst().orElse(-1);

        if (index == -1) {
            return null;
        }

        list.set(index, task);

        return task;
    }

    public void delete(Long id) {
        list.remove(list.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null));
    }
}

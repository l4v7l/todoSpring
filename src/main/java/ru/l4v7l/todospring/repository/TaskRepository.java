package ru.l4v7l.todospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.l4v7l.todospring.entity.Task;
import ru.l4v7l.todospring.enume.TaskStatus;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByAuthor_Id(Long id);

    List<Task> findAllByStatus(TaskStatus status);

    List<Task> findAllByOrderByStatus();

    List<Task> findAllByOrderByDueDate();
}

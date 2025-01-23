package ru.l4v7l.todospring.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.l4v7l.todospring.enume.TaskStatus;

import java.time.LocalDate;


@Getter
@Setter
@RequiredArgsConstructor
public class TaskDto {


    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
    private LocalDate dueDate;


}

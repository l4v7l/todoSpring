package ru.l4v7l.todospring.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
public class TaskDto {

    private Long id;
    private String title;
    private String description;
    private String status;
    private LocalDate dueDate;
    private Long author;
}

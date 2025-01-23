package ru.l4v7l.todospring.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@RequiredArgsConstructor
public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private List<TaskDto> tasks;
}

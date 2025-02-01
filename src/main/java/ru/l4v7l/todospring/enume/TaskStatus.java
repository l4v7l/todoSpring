package ru.l4v7l.todospring.enume;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TaskStatus {
    DONE("DONE"),
    TODO("TODO"),
    IN_PROGRESS("IN_PROGRESS");

    private final String value;
}

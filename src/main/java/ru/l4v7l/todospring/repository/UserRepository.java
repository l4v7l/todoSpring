package ru.l4v7l.todospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.l4v7l.todospring.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

package com.rohater.todo_list.repository;

import com.rohater.todo_list.model.Task;
import com.rohater.todo_list.model.User;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TaskRepository
        extends CrudRepository<Task, Long>{

   Optional<Task> findTaskById(Long id);

   List<Task> findTasksByCreationDateBetween(LocalDateTime start, LocalDateTime end);

   List<Task> findAllByCreationDate(LocalDateTime creationDate);

   List<Task> findByUser(Optional<User> user);
}
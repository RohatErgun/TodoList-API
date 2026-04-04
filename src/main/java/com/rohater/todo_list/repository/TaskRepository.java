package com.rohater.todo_list.repository;

import com.rohater.todo_list.model.Task;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository
        extends CrudRepository<Task, Long>{

   Task findTaskById(Long id);

   List<Task> findTasksByCreationDateBetween(LocalDateTime start, LocalDateTime end);

   List<Task> findAllByCreationDate(LocalDateTime creationDate);
}
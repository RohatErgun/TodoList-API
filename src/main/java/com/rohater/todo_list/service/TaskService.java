package com.rohater.todo_list.service;

import com.rohater.todo_list.model.Task;
import com.rohater.todo_list.repository.TaskRepository;
import com.rohater.todo_list.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class TaskService {

    private final TaskRepository taskRepo;

    public TaskService(TaskRepository taskRepo){
        this.taskRepo = taskRepo;
    }

    public Task findTaskById(Long id){
        return taskRepo.findTaskById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public List<Task> findTasksByCreationDateBetween(LocalDateTime start, LocalDateTime end){

    }

    public List<Task> findAllByCreationDate(LocalDateTime creationDate){

    }

    public List<Task> findByUser(User user){

    }

}

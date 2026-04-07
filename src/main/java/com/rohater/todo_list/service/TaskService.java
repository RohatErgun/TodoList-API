package com.rohater.todo_list.service;

import com.rohater.todo_list.model.Task;
import com.rohater.todo_list.repository.TaskRepository;
import com.rohater.todo_list.model.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class TaskService {

    private final TaskRepository taskRepo;

    public TaskService(TaskRepository taskRepo){
        this.taskRepo = taskRepo;
    }

    public Task save(Task task){
        return taskRepo.save(task);
    }

    public void deleteById(Long id){
        if(!taskRepo.existsById(id)){
            throw new RuntimeException("Task not found");
        }
        taskRepo.deleteById(id);
    }

    public Task findTaskById(Long id){
        return taskRepo.findTaskById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public List<Task> findTasksByCreationDateBetween(LocalDateTime start, LocalDateTime end){
        return taskRepo.findTasksByCreationDateBetween(start, end);
    }

    public List<Task> findAllByCreationDate(LocalDateTime creationDate){
        return taskRepo.findAllByCreationDate(creationDate);
    }

    public List<Task> findByUser(User user){
        return taskRepo.findByUser(user);
    }

}

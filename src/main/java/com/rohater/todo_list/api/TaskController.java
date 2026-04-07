package com.rohater.todo_list.api;

import com.rohater.todo_list.model.Task;
import com.rohater.todo_list.model.User;
import com.rohater.todo_list.service.TaskService;
import com.rohater.todo_list.service.UserService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/tasks", produces = "application/json")
public class TaskController {
    private final TaskService taskService;
    private final UserService userService;

    public TaskController(TaskService taskService, UserService userService){
        this.taskService = taskService;
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable("id") Long id){
        return taskService.findTaskById(id);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Task postTask(
            @RequestBody Task task){
        return taskService.save(task);
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public Task putTask(@PathVariable("id") Long id, @RequestBody Task task){
        task.setId(id);
        return taskService.save(task);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable("id") Long id){
        taskService.deleteById(id);
    }

    @GetMapping("/between-dates")
    public List<Task> getTasksByCreationDateBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end){

        return taskService.findTasksByCreationDateBetween(start, end);
    }

    @GetMapping("/creation-date")
    public List<Task> getAllByCreationDate(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime creationDate){
        return taskService.findAllByCreationDate(creationDate);
    }

    @GetMapping("/user/{userId}")
    public List<Task> getTaskByUser(@PathVariable Long userId){
        User user = userService.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("User not Found"));
        return taskService.findByUser(user);
    }

}

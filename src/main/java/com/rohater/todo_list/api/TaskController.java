package com.rohater.todo_list.api;

import com.rohater.todo_list.repository.TaskRepository;
import com.rohater.todo_list.service.TaskService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/tasks", produces = "application/json")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    
}

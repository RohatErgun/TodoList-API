package com.rohater.todo_list.api;

import com.rohater.todo_list.model.Task;
import com.rohater.todo_list.service.TaskService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/tasks", produces = "application/json")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable("id") Long id){
        return taskService.findTaskById(id);
    }

}

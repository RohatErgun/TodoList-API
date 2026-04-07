package com.rohater.todo_list.api;

import com.rohater.todo_list.model.Task;
import com.rohater.todo_list.service.TaskService;
import org.springframework.http.HttpStatus;
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

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Task postTask(Task task){
        return taskService.save(task);
    }

    @PutMapping(value = "{/id}", consumes = "application/json")
    public Task putTask(@PathVariable("id") Long id, @RequestBody Task task){
        task.setId(id);
        return taskService.save(task);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable("id") Long id){
        taskService.deleteById(id);
    }


}

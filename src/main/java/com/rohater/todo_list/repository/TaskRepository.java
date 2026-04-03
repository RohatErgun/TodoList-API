package com.rohater.todo_list.repository;

import com.rohater.todo_list.model.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository
        extends CrudRepository<Task, Long>{


}
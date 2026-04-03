package com.rohater.todo_list.repository;


import com.rohater.todo_list.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository
        extends CrudRepository<User, Long> {

}
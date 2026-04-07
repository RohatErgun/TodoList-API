package com.rohater.todo_list.service;

import com.rohater.todo_list.model.User;
import com.rohater.todo_list.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    private UserRepository userRepo;

    public UserService(UserRepository userRepo){
        this.userRepo = userRepo;
    }

    public Optional<User> finByUserId(Long userId){
        return userRepo.findById(userId);
    }
}

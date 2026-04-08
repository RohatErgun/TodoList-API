package com.rohater.todo_list.service;

import com.rohater.todo_list.model.User;
import com.rohater.todo_list.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    private final UserRepository userRepo;

    public UserService(UserRepository userRepo){
        this.userRepo = userRepo;
    }

    public Optional<User> findByUserId(Long userId){
        return userRepo.findById(userId);
    }

    public User saveUser(User user){
        return userRepo.save(user);
    }

    public List<User> getUsers(){
        return (List<User>) userRepo.findAll();
    }
}

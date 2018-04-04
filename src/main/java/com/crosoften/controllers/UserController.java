package com.crosoften.controllers;

import com.crosoften.model.User;
import com.crosoften.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    private UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> getAllNotes() {
        return this.userRepository.findAll();
    }

    @PostMapping("/saveUser")
    public User createUser(@RequestBody User request) {
        return this.userRepository.save(request);
    }

}

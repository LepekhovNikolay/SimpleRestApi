package com.rest.controller;

import com.rest.model.User;
import com.rest.repository.UserRepository;
import com.rest.exceptions.UserNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController()
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @GetMapping("/users/all_ids")
    public List<Long> getAllIds() {
        return repository.findAll().stream().map(User::getId).collect(Collectors.toList());
    }

    @GetMapping("/users")
    public List<User> getAll() {
        return repository.findAll();
    }

}

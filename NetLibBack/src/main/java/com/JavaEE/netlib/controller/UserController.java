package com.JavaEE.netlib.controller;

import com.JavaEE.netlib.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path="/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(path = "/{username}")
    public Optional<User> getUser(@PathVariable String username) {
        return userService.getByUsername(username);
    }
}

package com.JavaEE.netlib.controller;

import com.JavaEE.netlib.domain.User;
import com.JavaEE.netlib.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(path = "/{username}")
    public Optional<User> getUser(@PathVariable String username) {
        return userService.getByUsername(username);
    }

    @PostMapping(path="/register")
    public void createUser(@RequestBody User user) throws Exception {
        userService.saveUser(user);
    }

    @PostMapping(path="/login")
    public void loginUser(@RequestBody User user) throws Exception {
        userService.loginUser(user);


    }
}

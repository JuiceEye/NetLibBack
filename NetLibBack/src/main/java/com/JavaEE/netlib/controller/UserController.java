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
        userService.registerUser(user);
    }

//    @PostMapping(path="/login")
//    public void loginUser(@RequestBody User user) throws Exception {
//        userService.loginUser(user);
//    }

//    @PostMapping("/login")
//    public ResponseEntity<?> loginUser(@RequestBody User user, HttpSession session) {
//        if (userService.loginUser(user.getUsername(), user.getPassword())) {
//            session.setAttribute("username", user.getUsername());
//            return ResponseEntity.ok("User authenticated successfully");
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
//        }
//    }
//
//    // инфа о текущем пользователе из сессии
//    @GetMapping("/userInfo")
//    public ResponseEntity<?> getCurrentUser(HttpSession session) {
//        String username = (String) session.getAttribute("username");
//        if (username != null) {
//            return ResponseEntity.ok("Current user: " + username);
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not authenticated");
//        }
//    }
//
//    @PostMapping("/logout")
//    public ResponseEntity<?> logoutUser(HttpSession session) {
//        session.invalidate();
//        return ResponseEntity.ok("User logged out successfully");
//    }



}

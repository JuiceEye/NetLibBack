package com.JavaEE.netlib.service;

import com.JavaEE.netlib.models.User;
import com.JavaEE.netlib.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) throws Exception {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw new Exception("Error while saving a user.");
        }
    }

    public Optional<User> getByUsername(String login) {
        return Optional.ofNullable(userRepository.findByUsername(login));
    }
}

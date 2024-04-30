//package com.JavaEE.netlib.service;
//
//import com.JavaEE.netlib.domain.User;
//import com.JavaEE.netlib.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class UserService {
//    @Autowired
//    private UserRepository userRepository;
//    private PasswordEncoder passwordEncoder;
//
//
//    public User registerUser(User user) throws Exception {
//       user.setPassword(passwordEncoder.encode(user.getPassword()));
//
//       try {
//            return userRepository.save(user);
//        } catch (Exception e) {
//            throw new Exception("Error while saving a user.");
//        }
//    }
//
//    public Optional<User> getByUsername(String username) {
//        return Optional.ofNullable(userRepository.findByUsername(username));
//    }
//
//
////    public boolean loginUser(String username, String password) {
////        User user = userRepository.findByUsername(username);
////        if (user != null) {
////            return passwordEncoder.matches(password, user.getPassword());
////        }
////        return false;
////    }
//}
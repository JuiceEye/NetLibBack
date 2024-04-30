package com.JavaEE.netlib.controller;

import com.JavaEE.netlib.domain.User;
import com.JavaEE.netlib.domain.UserRole;
import com.JavaEE.netlib.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


//TEST TEXT ************************************************
//ляля тополя
@RestController
@RequestMapping(path="/user")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private final UserRepository repository;

    private final PasswordEncoder encoder = new BCryptPasswordEncoder();


    record NewUserRequest(
            Long id,
            String username,
            String password,
            String firstName,
            String lastName,
            String role
    ){}

//    record PwdUserRequest(
//            String password
//    ){}

//    @GetMapping(path = "/{username}")
//    public Optional<User> getUser(@PathVariable String username) {
//        return userService.getByUsername(username);
//    }


    @GetMapping("/login")
    public ResponseEntity<User> getAuth(@AuthenticationPrincipal UserDetails userAuth){
        try{
            User user = repository.findByUsername(userAuth.getUsername());
            System.out.println("OK!!!!!!!!");
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (NullPointerException e){
            System.out.println("Bad credentials");
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<User> addUser(@RequestBody NewUserRequest request,
                                           @AuthenticationPrincipal UserDetails userAuth){
        try{
            if(UserRole.valueOf(request.role()).equals(UserRole.ADMIN)){
                if(userAuth.getAuthorities().contains(new SimpleGrantedAuthority(UserRole.ADMIN.toString()))){
                    User user = new User();
                    user.setUsername(request.username());
                    user.setPassword(encoder.encode(request.password()));
                    user.setFirstName(request.firstName());
                    user.setLastName(request.lastName());
                    user.setRole(UserRole.valueOf(request.role));
                    repository.save(user);
                    User user1 = repository.findByUsername(user.getUsername());
                    return new ResponseEntity<>(user1, HttpStatus.OK);
                } else {
                    System.out.println("Error 1");
                    return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
                }
            } else {
                User user = new User();
                user.setUsername(request.username());
                user.setPassword(encoder.encode(request.password()));
                user.setFirstName(request.firstName());
                user.setLastName(request.lastName());
                user.setRole(UserRole.valueOf(request.role));
                repository.save(user);
                User user1 = repository.findByUsername(user.getUsername());
                return new ResponseEntity<>(user1, HttpStatus.OK);
            }
        } catch (NullPointerException e){
            System.out.println("Error 2");
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}

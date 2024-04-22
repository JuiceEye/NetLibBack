package com.JavaEE.netlib.service;

import com.JavaEE.netlib.domain.User;
import com.JavaEE.netlib.repository.UserRepository;
import com.JavaEE.netlib.security.UserSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DatabaseUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("user not found");
        }
        return new UserSecurity(user);
    }
}

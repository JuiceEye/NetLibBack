package com.JavaEE.netlib.security;

//import com.JavaEE.netlib.domain.UserRole;

import com.JavaEE.netlib.models.User;
import com.JavaEE.netlib.models.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class UserSecurity implements UserDetails {
    private User user;

    public UserSecurity(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(user.getRole().equals(UserRole.ADMIN)){
            return Arrays.asList(new SimpleGrantedAuthority(user.getRole().toString()), new SimpleGrantedAuthority(UserRole.USER.toString()));
        } else {
            return Arrays.asList(new SimpleGrantedAuthority(user.getRole().toString()));
        }
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

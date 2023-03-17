package com.example.thesis.config;

import com.example.thesis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
public class CustomUserDetails implements UserDetails {


    private User user;
    public CustomUserDetails(User user){
        super();
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        SimpleGrantedAuthority simpleGrantedAuthority =new SimpleGrantedAuthority(user.getRole());
//        return List.of(simpleGrantedAuthority);
        return Collections.singleton(new SimpleGrantedAuthority(user.getRole()));

    }

    @Override
    public String getPassword() {
        return user.getPass();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
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

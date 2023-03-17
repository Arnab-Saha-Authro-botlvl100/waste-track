package com.example.thesis.config;

import com.example.thesis.Services.UserService;
import com.example.thesis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    public UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException("could not found user");
        }
//        CustomUserDetails customUserDetails = new CustomUserDetails(user);
        return new CustomUserDetails(user);
    }
}

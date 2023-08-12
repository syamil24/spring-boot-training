package com.maybank.app.service;

import com.maybank.app.dto.Users;
import com.maybank.app.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.UserDetailsServiceConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository repository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = repository.findByName(username);
        UserDetails userDetails = User.withUsername(users.getName()).password(users.getPassword())
                .roles(users.getRole()).build();
        return userDetails;
    }

}

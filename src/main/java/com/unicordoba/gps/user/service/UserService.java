package com.unicordoba.gps.user.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.unicordoba.gps.user.model.User;

public interface UserService extends UserDetailsService{
    
    List<User> findAll();

    User findByUsername(String username);

    User findById(Long id);

    void save(User user);

    void delete(User user);

}

package com.unicordoba.gps.user.service;

import java.util.List;

import com.unicordoba.gps.user.model.User;
 
public interface UserService {
    
    List<User> findAll();

    User findByUsername(String username);

    User findById(Long id);

    void save(User user);

    void delete(User user);
    
}

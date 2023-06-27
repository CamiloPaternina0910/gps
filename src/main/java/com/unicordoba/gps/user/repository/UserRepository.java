package com.unicordoba.gps.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unicordoba.gps.user.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
    User findByUsername(String username);

}

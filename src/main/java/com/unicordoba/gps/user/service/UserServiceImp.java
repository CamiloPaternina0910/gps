package com.unicordoba.gps.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.unicordoba.gps.user.model.User;
import com.unicordoba.gps.user.repository.UserRepository;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void save(User user) {
       userRepository.save(user);
    }

    @Override
    public void delete(User user) {
       userRepository.delete(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        
      if (user == null) {
         throw new UsernameNotFoundException("User didn't find");
      }
      List<GrantedAuthority> authorities = new ArrayList<>();
      return new org.springframework.security.core.userdetails.User(user.getUsername() , user.getPassword() , authorities);
    }
    
}

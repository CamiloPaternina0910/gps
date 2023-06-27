package com.unicordoba.gps.user.mapper;

import org.springframework.stereotype.Component;

import com.unicordoba.gps.user.dto.UserRequest;
import com.unicordoba.gps.user.model.User;

@Component
public class UserMapperImp implements UserMapper{

    @Override
    public User toEntity(UserRequest request) {
        if(request == null) return null;

        User user = new User();
        user.setPassword(request.getPassword());
        user.setUsername(request.getUsername());
        
        return user;
    }
    
}

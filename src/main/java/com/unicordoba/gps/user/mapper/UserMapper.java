package com.unicordoba.gps.user.mapper;

import com.unicordoba.gps.user.dto.UserRequest;
import com.unicordoba.gps.user.model.User;

public interface UserMapper {
    
    User toEntity(UserRequest request);

}

package com.unicordoba.gps.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicordoba.gps.user.dto.UserRequest;
import com.unicordoba.gps.user.mapper.UserMapper;
import com.unicordoba.gps.user.model.User;
import com.unicordoba.gps.user.service.UserService;
import com.unicordoba.utils.Response;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/create")
    public ResponseEntity<Response> createUser(@Valid @RequestBody UserRequest request){
        User user = userMapper.toEntity(request);
        userService.save(user);
        return new ResponseEntity<Response>(
            new Response(false, "User created", "200-OK"), 
            HttpStatus.OK
            );
    }

}

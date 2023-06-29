package com.unicordoba.gps.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicordoba.gps.security.JwtUtil;
import com.unicordoba.gps.user.dto.UserRequest;
import com.unicordoba.gps.user.mapper.UserMapper;
import com.unicordoba.gps.user.model.User;
import com.unicordoba.gps.user.service.UserService;
import com.unicordoba.gps.utils.Response;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/create")
    public ResponseEntity<Response> createUser(@Valid @RequestBody UserRequest request) {
        User user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        return new ResponseEntity<Response>(
                new Response(false, "User created", "200-OK"),
                HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Response> login(@Valid @RequestBody UserRequest request) {
        return loguear(request);
    }

    private ResponseEntity<Response> loguear(UserRequest request) {
        UsernamePasswordAuthenticationToken authenticationToken = UsernamePasswordAuthenticationToken.unauthenticated(request.getUsername(), request.getPassword());
        this.authenticationManager.authenticate(authenticationToken);
        UserDetails userDetails = userService.loadUserByUsername(request.getUsername());
        System.out.println(userDetails.getUsername());
        String token = jwtUtil.createToken(userDetails);
        System.out.println(token);
        return new ResponseEntity<>(
                new Response(false, token, "200-OK"),
                HttpStatus.OK);
    }
}

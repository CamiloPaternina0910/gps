package com.unicordoba.gps.security.config;

import org.springframework.beans.factory.annotation.Value;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConfigJwt {

    @Value("${jwt_secret}")
    private String JWT_SECRET;

    @Value("${jwt_expiration_time}")
    private int JWT_EXPIRATION_TIME;
    
}

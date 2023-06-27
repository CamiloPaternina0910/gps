package com.unicordoba.gps.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    
    @NotEmpty(message = "Username is required")
    @Email(message = "Formatt not support")
    private String username;

    @Size(min = 8, message = "Length's password should be more 8 characters")
    private String password; 

}

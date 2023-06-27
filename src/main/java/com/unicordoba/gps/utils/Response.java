package com.unicordoba.gps.utils;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {
    
    private Boolean err;

    private Object data;

    private String statusCode;

    private LocalDateTime timestamp;

    public Response(
        Boolean err,
        Object data,
        String statusCode
    ){
        this.err = err;
        this.data = data;
        this.statusCode = statusCode;
    }
    
}

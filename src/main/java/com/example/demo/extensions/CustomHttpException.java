package com.example.demo.extensions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CustomHttpException extends RuntimeException {
    public CustomHttpException(String message) {
        super(message);
    }
}

package com.example.lsi1.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CarNotFoundException extends Exception {
    public CarNotFoundException(String message) {
        super(message);
    }
}

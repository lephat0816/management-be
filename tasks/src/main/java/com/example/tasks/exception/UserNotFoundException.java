package com.example.tasks.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id) {
        super("Cound not found user with" + id);
    }
}

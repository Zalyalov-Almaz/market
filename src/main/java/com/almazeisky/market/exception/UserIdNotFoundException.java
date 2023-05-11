package com.almazeisky.market.exception;

public class UserIdNotFoundException extends RuntimeException{

    public UserIdNotFoundException(String message) {
        super(message);
    }
}

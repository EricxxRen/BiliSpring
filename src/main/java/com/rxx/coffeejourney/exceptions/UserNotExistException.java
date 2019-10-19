package com.rxx.coffeejourney.exceptions;

public class UserNotExistException extends RuntimeException {

    public UserNotExistException() {
        super("User Not Exist");
    }
}

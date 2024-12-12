package com.ultratech.passwordgenerator.exception;

public class UserException extends RuntimeException {

    public static final String userNotFound = "User.userNotFound";

    public UserException(String message) {
        super(message);
    }
}

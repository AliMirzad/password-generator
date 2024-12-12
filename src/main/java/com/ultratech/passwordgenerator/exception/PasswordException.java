package com.ultratech.passwordgenerator.exception;

public class PasswordException extends RuntimeException {

    public static final String passwordNotFound = "Password.passwordNotFound";

    public PasswordException(String message) {
        super(message);
    }
}

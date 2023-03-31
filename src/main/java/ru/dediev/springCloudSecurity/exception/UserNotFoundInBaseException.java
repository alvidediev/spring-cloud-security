package ru.dediev.springCloudSecurity.exception;

public class UserNotFoundInBaseException extends Exception{
    public UserNotFoundInBaseException(String message) {
        super(message);
    }
}

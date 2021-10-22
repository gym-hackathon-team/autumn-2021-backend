package com.gymteam.backend.bff.exception.auth;

import lombok.Getter;

@Getter
public class PasswordMismatchException extends Exception {
    String message;
    public PasswordMismatchException(String message) {
        this.message=message;
    }
    public PasswordMismatchException() {
        this.message="Password and confirmation don't match";
    }
}

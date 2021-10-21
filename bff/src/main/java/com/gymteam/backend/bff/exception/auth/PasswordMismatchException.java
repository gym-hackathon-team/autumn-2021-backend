package com.gymteam.backend.bff.exception.auth;

import lombok.Getter;

@Getter
public class PasswordMismatchException extends Exception {
    String message="Password and confirmation don't match";
    public PasswordMismatchException() {
    }
}

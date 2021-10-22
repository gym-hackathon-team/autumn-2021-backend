package com.gymteam.backend.bff.exception.auth;

import lombok.Getter;

@Getter
public class FieldEmptyException extends Exception {
    String message;
    public FieldEmptyException()
    {
        this.message="Some required fields are empty";
    }
    public FieldEmptyException(String message)
    {
        this.message=message;
    }
}

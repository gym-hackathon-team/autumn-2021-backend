package com.gymteam.backend.bff.exception.auth;

import lombok.Getter;

@Getter
public class FieldEmptyException extends Exception {
    String message="Some required fields are empty";
    public FieldEmptyException()
    {

    }
}

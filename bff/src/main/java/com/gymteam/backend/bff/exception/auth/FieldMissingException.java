package com.gymteam.backend.bff.exception.auth;

import lombok.Getter;

@Getter
public class FieldMissingException extends Exception{
    String message="Some required fields are missing";
    public FieldMissingException()
    {

    }
}

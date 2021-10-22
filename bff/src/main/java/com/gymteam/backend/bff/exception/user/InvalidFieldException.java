package com.gymteam.backend.bff.exception.user;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.List;

public class InvalidFieldException extends RuntimeException implements GraphQLError {


    public InvalidFieldException(String message)
    {

        super(message);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return null;
    }
}

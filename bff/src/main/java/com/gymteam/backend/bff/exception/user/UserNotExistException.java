package com.gymteam.backend.bff.exception.user;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.List;

public class UserNotExistException extends RuntimeException implements GraphQLError {


    public UserNotExistException()
    {

        super("This user is not exist!");
    }
    public UserNotExistException(String message)
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

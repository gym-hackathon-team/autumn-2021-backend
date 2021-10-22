package com.gymteam.backend.bff.exception.client;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.List;

public class ClientException extends RuntimeException implements GraphQLError {


    public ClientException(String message)
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

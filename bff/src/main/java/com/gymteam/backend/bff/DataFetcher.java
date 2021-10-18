package com.gymteam.backend.bff;

import graphql.schema.DataFetchingEnvironment;

public interface DataFetcher<T> extends graphql.schema.DataFetcher {
    T get(DataFetchingEnvironment dataFetchingEnvironment) throws Exception;
}
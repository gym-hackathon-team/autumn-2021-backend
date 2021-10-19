package com.gymteam.backend.bff.service;

import com.gymteam.backend.bff.repository.BookDataFetcherRepository;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;


@Service
public class GraphQLService {

    private GraphQL graphQL;


    @Autowired
    BookDataFetcherRepository bookFetcher;

    @Value("schema.graphqls")
    private ClassPathResource classPathLoader;

    @PostConstruct
    private void loadSchema() throws IOException {
        InputStream st = classPathLoader.getInputStream();
        Reader targetReader = new InputStreamReader(st);

        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(targetReader);
        RuntimeWiring runtimeWiring = buildRuntimeWiring();

        GraphQLSchema graphQLSchema = new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
        graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }


    //Test
    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type(TypeRuntimeWiring.newTypeWiring("Query")
                        .dataFetcher("books", bookFetcher))
                .build();
    }

    @Bean
    public GraphQL graphQL() {
        return graphQL;
    }
}
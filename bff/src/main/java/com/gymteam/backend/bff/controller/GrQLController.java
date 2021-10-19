package com.gymteam.backend.bff.controller;


import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.gymteam.backend.bff.service.GraphQLService;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
public class GrQLController {


    @Autowired
    GraphQLService graphQLService;

    @RequestMapping(value = "/api")
    public String getData(@RequestBody String query) throws JsonIOException, IOException {
        ExecutionResult execute = graphQLService.graphQL().execute(query);
        Map<String, String> obj = (Map<String, String>) execute.getData();
        Gson gson = new Gson();
        String json = gson.toJson(obj);
        return json;
    }
}

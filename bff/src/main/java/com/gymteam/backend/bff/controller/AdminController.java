package com.gymteam.backend.bff.controller;


import com.gymteam.backend.bff.client.AdminServiceClient;

import com.gymteam.backend.bff.dto.Admin;

import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
@AllArgsConstructor
public class AdminController {


    private final AdminServiceClient adminServiceClient;

    @SchemaMapping(typeName="Query", field="getAdmin")
    Admin get(@Argument UUID id)
    {
        return adminServiceClient.getAdmin(id);
    }


    @SchemaMapping(typeName="Mutation", field="createAdmin")
    Admin create(@Argument Admin admin)
    {
        return adminServiceClient.createAdmin(admin);
    }

    @SchemaMapping(typeName="Mutation", field="updateAdmin")
    Admin update(@Argument Admin admin)
    {

        return adminServiceClient.updateAdmin(admin);
    }
}

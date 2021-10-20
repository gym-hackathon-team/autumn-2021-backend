package com.gymteam.backend.bff.controller;


import com.gymteam.backend.bff.client.UserServiceClient;
import com.gymteam.backend.bff.dto.User;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserServiceClient userServiceClient;

    @SchemaMapping(typeName="Query", field="getUser")
    User get(@Argument UUID id)
    {
        return userServiceClient.getUser(id);
    }


    @SchemaMapping(typeName="Mutation", field="createUser")
    User create(@Argument User user)
    {
        return userServiceClient.createUser(user);
    }

    @SchemaMapping(typeName="Mutation", field="updateUser")
    User update(@Argument User user)
    {

        return userServiceClient.updateUser(user);
    }

}

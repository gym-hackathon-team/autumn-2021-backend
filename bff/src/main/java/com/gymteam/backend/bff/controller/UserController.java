package com.gymteam.backend.bff.controller;

import com.gymteam.backend.bff.dto.User;
import com.gymteam.backend.bff.service.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @SchemaMapping(typeName = "Query", field = "getUser")
    User get(@Argument UUID id) {
        return userService.get(id);
    }

    @SchemaMapping(typeName = "Mutation", field = "updateUser")
    User update(@Argument User user) {
        return userService.update(user);
    }
}

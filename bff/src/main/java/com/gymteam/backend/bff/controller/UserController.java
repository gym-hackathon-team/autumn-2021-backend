package com.gymteam.backend.bff.controller;


import com.gymteam.backend.bff.dto.User;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
public class UserController {



    @SchemaMapping(typeName="Query", field="getUser")
    User get(@Argument UUID id)
    {

        User us=new User();
        us.setId(id);
        us.setEmail("gg");
        us.setPassword("gg");
        us.setFirstName("gg");
        us.setLastName("gg");
        return us;
    }


    @SchemaMapping(typeName="Mutation", field="createUser")
    User create(@Argument User user)
    {
        user.setId(UUID.randomUUID());
        return user;
    }

    @SchemaMapping(typeName="Mutation", field="updateUser")
    User update(@Argument User user)
    {

        return user;
    }

}

package com.gymteam.backend.bff.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.gymteam.backend.bff.dto.user.UserDto;
import com.gymteam.backend.bff.service.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class UserQuery implements GraphQLQueryResolver {

    private final UserService userService;

    public UserDto getUser(UUID id) {
        return userService.get(id);
    }
}

package com.gymteam.backend.bff.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.gymteam.backend.bff.dto.User;
import com.gymteam.backend.bff.service.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class UserMutation implements GraphQLMutationResolver {

    private final UserService userService;

    public User updateUser(UUID id, String email, String password, String firstName, String lastName) {
        User user = new User();
        user.setId(id);
        user.setEmail(email);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);

        return userService.update(user);
    }
}

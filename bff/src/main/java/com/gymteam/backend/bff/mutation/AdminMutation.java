package com.gymteam.backend.bff.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.gymteam.backend.bff.dto.Admin;
import com.gymteam.backend.bff.service.interfaces.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class AdminMutation implements GraphQLMutationResolver {

    private final AdminService adminService;

    public Admin updateAdmin(UUID id, String email, String password, String firstName, String lastName) {
        Admin admin = new Admin();
        admin.setId(id);
        admin.setEmail(email);
        admin.setPassword(password);
        admin.setFirstName(firstName);
        admin.setLastName(lastName);

        return adminService.update(admin);
    }
}

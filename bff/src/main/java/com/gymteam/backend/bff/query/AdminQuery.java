package com.gymteam.backend.bff.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.gymteam.backend.bff.dto.Admin;
import com.gymteam.backend.bff.service.interfaces.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class AdminQuery implements GraphQLQueryResolver {

    private AdminService adminService;

    public Admin getAdmin(UUID id) {
        return adminService.get(id);
    }
}

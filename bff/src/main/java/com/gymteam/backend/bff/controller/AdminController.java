package com.gymteam.backend.bff.controller;

import com.gymteam.backend.bff.dto.Admin;
import com.gymteam.backend.bff.service.interfaces.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
@AllArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @SchemaMapping(typeName = "Query", field = "getAdmin")
    Admin get(@Argument UUID id) {
        return adminService.get(id);
    }

    @SchemaMapping(typeName = "Mutation", field = "updateAdmin")
    Admin update(@Argument Admin admin) {
        return adminService.update(admin);
    }
}

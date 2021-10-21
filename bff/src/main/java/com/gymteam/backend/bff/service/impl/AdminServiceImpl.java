package com.gymteam.backend.bff.service.impl;

import com.gymteam.backend.bff.client.AdminClient;
import com.gymteam.backend.bff.dto.Admin;
import com.gymteam.backend.bff.service.interfaces.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminClient adminClient;

    @Override
    public Admin get(UUID id) {
        return adminClient.getAdmin(id);
    }

    @Override
    public Admin update(Admin admin) {
        return adminClient.updateAdmin(admin);
    }
}

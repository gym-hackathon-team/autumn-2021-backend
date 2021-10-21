package com.gymteam.backend.bff.service.interfaces;

import com.gymteam.backend.bff.dto.Admin;

import java.util.UUID;

public interface AdminService {

    Admin get(UUID id);

    Admin update(Admin admin);
}

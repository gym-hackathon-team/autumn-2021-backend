package com.gymteam.backend.admin.service.interfaces;

import com.gymteam.backend.admin.entity.Admin;
import com.gymteam.backend.admin.exception.NotFoundException;

import java.util.UUID;

public interface AdminService {

    Admin getAdmin(UUID id) throws NotFoundException;

    void createAdmin(Admin admin);

    Admin updateAdmin(Admin admin) throws NotFoundException;
}

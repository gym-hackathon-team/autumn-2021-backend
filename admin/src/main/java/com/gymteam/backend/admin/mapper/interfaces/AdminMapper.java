package com.gymteam.backend.admin.mapper.interfaces;

import com.gymteam.backend.admin.dto.AdminDto;
import com.gymteam.backend.admin.entity.Admin;

public interface AdminMapper {

    Admin convertToEntity(AdminDto dto);

    AdminDto convertToDto(Admin dto);
}

package com.gymteam.backend.admin.mapper.impl;

import com.gymteam.backend.admin.dto.AdminDto;
import com.gymteam.backend.admin.entity.Admin;
import com.gymteam.backend.admin.mapper.interfaces.AdminMapper;
import org.springframework.stereotype.Service;

@Service
public class AdminMapperImpl implements AdminMapper {

    @Override
    public Admin convertToEntity(AdminDto dto) {
        Admin entity = new Admin();
        entity.setId(dto.getId());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        return entity;
    }

    @Override
    public AdminDto convertToDto(Admin entity) {
        AdminDto dto = new AdminDto();
        dto.setId(entity.getId());
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        return dto;
    }
}

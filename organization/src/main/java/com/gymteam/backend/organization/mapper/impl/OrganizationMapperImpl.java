package com.gymteam.backend.organization.mapper.impl;

import com.gymteam.backend.organization.dto.bff.OrganizationDto;
import com.gymteam.backend.organization.entity.Organization;
import com.gymteam.backend.organization.mapper.interfaces.OrganizationMapper;
import org.springframework.stereotype.Service;

@Service
public class OrganizationMapperImpl implements OrganizationMapper {

    @Override
    public Organization convertToEntity(OrganizationDto dto) {
        Organization entity = new Organization();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }

    @Override
    public OrganizationDto convertToDto(Organization entity) {
        OrganizationDto dto = new OrganizationDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}

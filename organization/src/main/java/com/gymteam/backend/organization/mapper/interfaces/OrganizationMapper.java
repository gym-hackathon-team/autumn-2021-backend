package com.gymteam.backend.organization.mapper.interfaces;

import com.gymteam.backend.organization.dto.bff.OrganizationDto;
import com.gymteam.backend.organization.entity.Organization;

public interface OrganizationMapper {

    Organization convertToEntity(OrganizationDto dto);

    OrganizationDto convertToDto(Organization dto);
}

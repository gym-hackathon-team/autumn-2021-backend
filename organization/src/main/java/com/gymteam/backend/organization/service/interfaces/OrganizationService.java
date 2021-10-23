package com.gymteam.backend.organization.service.interfaces;

import com.gymteam.backend.organization.entity.Organization;
import com.gymteam.backend.organization.exception.NotFoundException;

import java.util.UUID;

public interface OrganizationService {

    Organization getOrganization(UUID id) throws NotFoundException;
}

package com.gymteam.backend.organization.service.impl;

import com.gymteam.backend.organization.entity.Organization;
import com.gymteam.backend.organization.exception.NotFoundException;
import com.gymteam.backend.organization.repository.OrganizationRepository;
import com.gymteam.backend.organization.service.interfaces.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;

    @Override
    public Organization getOrganization(UUID id) throws NotFoundException {
        Optional<Organization> customerOptional = organizationRepository.findById(id);
        return customerOptional.orElseThrow(NotFoundException::new);
    }
}

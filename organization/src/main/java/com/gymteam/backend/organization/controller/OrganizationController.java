package com.gymteam.backend.organization.controller;

import com.gymteam.backend.organization.dto.bff.OrganizationDto;
import com.gymteam.backend.organization.exception.NotFoundException;
import com.gymteam.backend.organization.mapper.interfaces.OrganizationMapper;
import com.gymteam.backend.organization.service.interfaces.OrganizationService;
import com.gymteam.backend.organization.dto.bff.OrganizationDto;
import com.gymteam.backend.organization.entity.Organization;
import com.gymteam.backend.organization.exception.NotFoundException;
import com.gymteam.backend.organization.mapper.interfaces.OrganizationMapper;
import com.gymteam.backend.organization.service.interfaces.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class OrganizationController {

    private final OrganizationService organizationService;

    private final OrganizationMapper mapper;

    @GetMapping("/{id}")
    public ResponseEntity<OrganizationDto> read(@PathVariable UUID id) {
        try {
            return new ResponseEntity<>(mapper.convertToDto(organizationService.getOrganization(id)), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

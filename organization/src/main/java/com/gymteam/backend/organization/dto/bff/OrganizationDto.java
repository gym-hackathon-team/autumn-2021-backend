package com.gymteam.backend.organization.dto.bff;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class OrganizationDto {

    private UUID id;

    private String name;
}

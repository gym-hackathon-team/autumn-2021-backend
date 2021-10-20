package com.gymteam.backend.admin.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AdminDto {

    private UUID id;

    private String email;

    private String password;

    private String firstName;

    private String lastName;
}

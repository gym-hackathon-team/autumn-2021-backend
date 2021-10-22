package com.gymteam.backend.user.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserDto {

    private UUID id;

    private String email;

    private String password;

    private String firstName;

    private String lastName;
}

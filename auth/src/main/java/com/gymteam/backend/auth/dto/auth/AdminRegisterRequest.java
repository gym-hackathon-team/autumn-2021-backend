package com.gymteam.backend.auth.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AdminRegisterRequest {

    private final String email;

    private final String password;

    private final String passwordConfirmation;

    private final String firstName;

    private final String lastName;

}

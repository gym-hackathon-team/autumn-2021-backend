package com.gymteam.backend.bff.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserLoginRequest {

    private final String email;

    private final String password;
}

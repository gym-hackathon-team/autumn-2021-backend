package com.gymteam.backend.auth.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AdminLoginRequest {

    private final String email;

    private final String password;

}

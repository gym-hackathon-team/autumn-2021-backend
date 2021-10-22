package com.gymteam.backend.bff.service.impl;

import com.gymteam.backend.bff.client.AuthClient;
import com.gymteam.backend.bff.dto.auth.TokenDto;
import com.gymteam.backend.bff.dto.auth.UserDto;
import com.gymteam.backend.bff.dto.auth.UserLoginRequest;

import com.gymteam.backend.bff.service.interfaces.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthClient authClient;

    @Override
    public TokenDto signInUser(UserLoginRequest request) {

        return authClient.signInUser(request);
    }


}

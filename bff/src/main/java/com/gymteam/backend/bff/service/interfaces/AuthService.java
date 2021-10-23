package com.gymteam.backend.bff.service.interfaces;

import com.gymteam.backend.bff.dto.auth.TokenDto;
import com.gymteam.backend.bff.dto.auth.UserLoginRequest;

public interface AuthService {

    TokenDto signInUser(UserLoginRequest request);
}

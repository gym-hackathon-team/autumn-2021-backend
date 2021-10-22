package com.gymteam.backend.auth.service.interfaces;

import com.gymteam.backend.auth.dto.UserDto;
import com.gymteam.backend.auth.entity.Token;

import java.util.Optional;

public interface TokenService {

    Optional<Token> get(String jwt);

    Token create(UserDto user);
}

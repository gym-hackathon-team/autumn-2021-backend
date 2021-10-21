package com.gymteam.backend.auth.service.impl;

import com.gymteam.backend.auth.entity.Token;
import com.gymteam.backend.auth.repository.TokenRepository;
import com.gymteam.backend.auth.service.interfaces.TokenService;
import com.gymteam.backend.auth.util.JwtProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TokenServiceImpl implements TokenService {

    private final JwtProvider jwtProvider;

    private final TokenRepository tokenRepository;

    @Override
    public Optional<Token> get(String jwt) {
        return tokenRepository.findTokenByValue(jwt);
    }

}

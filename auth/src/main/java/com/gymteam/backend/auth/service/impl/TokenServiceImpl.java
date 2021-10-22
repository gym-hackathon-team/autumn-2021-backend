package com.gymteam.backend.auth.service.impl;

import com.gymteam.backend.auth.dto.bff.UserDto;
import com.gymteam.backend.auth.entity.Token;
import com.gymteam.backend.auth.repository.TokenRepository;
import com.gymteam.backend.auth.service.interfaces.TokenService;
import com.gymteam.backend.auth.util.JwtProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TokenServiceImpl implements TokenService {

    private final JwtProvider jwtProvider;

    private final TokenRepository tokenRepository;

    @Override
    public Optional<Token> get(String jwt) {
        return tokenRepository.findTokenByValue(jwt);
    }

    @Override
    public Token create(UserDto user) {
        String value = jwtProvider.generateToken(user.getEmail());

        return tokenRepository.save(createToken(value, user.getId(), "user"));
    }

    private Token createToken(String value, UUID entityId, String scope) {
        Token token = new Token();
        token.setValue(value);
        token.setExpired(false);
        token.setEntityId(entityId);
        token.setScope(scope);
        return token;
    }

}

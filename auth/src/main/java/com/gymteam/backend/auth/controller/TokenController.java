package com.gymteam.backend.auth.controller;

import com.gymteam.backend.auth.dto.bff.AuthorizedDto;
import com.gymteam.backend.auth.entity.Token;
import com.gymteam.backend.auth.service.interfaces.TokenService;
import com.gymteam.backend.auth.util.JwtProvider;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/token")
@AllArgsConstructor
public class TokenController {

    private final JwtProvider jwtProvider;

    private final TokenService tokenService;

    @GetMapping("/authorize")
    public ResponseEntity<AuthorizedDto> authorize(@RequestHeader String jwt) {
        // TODO Move logic to service

        jwtProvider.validateToken(jwt);

        if (jwtProvider.validateToken(jwt)) {

            Optional<Token> token = tokenService.get(jwt);

            if (token.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(new AuthorizedDto(token.get().getScope()), HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}

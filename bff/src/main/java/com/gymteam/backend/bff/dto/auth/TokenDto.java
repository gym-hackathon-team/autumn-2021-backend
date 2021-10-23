package com.gymteam.backend.bff.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter

public class TokenDto {

    private UUID userId;
    private String token;

}

package com.gymteam.backend.auth.dto.bff;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class TokenDto {
    private UUID userId;
    private String token;
}

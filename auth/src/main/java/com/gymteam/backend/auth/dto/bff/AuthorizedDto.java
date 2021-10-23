package com.gymteam.backend.auth.dto.bff;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class AuthorizedDto {

    private UUID uuid;
}

package com.gymteam.backend.auth.dto.bff;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthorizedDto {

    private final String scope;
}

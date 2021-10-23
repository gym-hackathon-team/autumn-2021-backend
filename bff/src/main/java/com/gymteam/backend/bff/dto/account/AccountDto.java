package com.gymteam.backend.bff.dto.account;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AccountDto {

    private UUID id;
    private String number;
    private AccountType type;
    private UUID userId;
    private UUID organizationId;
    private double balance;
}


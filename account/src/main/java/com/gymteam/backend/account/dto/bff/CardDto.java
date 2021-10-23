package com.gymteam.backend.account.dto.bff;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CardDto {

    private UUID id;

    private String number;

    private Double balance;

    private UUID accountId;
}

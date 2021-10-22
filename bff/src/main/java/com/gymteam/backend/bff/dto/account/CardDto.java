package com.gymteam.backend.bff.dto.account;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CardDto {

    private UUID id;
    private double balance;
    private UUID accountId;
    private String number;
}

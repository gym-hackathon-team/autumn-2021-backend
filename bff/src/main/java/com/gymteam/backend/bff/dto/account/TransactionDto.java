package com.gymteam.backend.bff.dto.account;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class TransactionDto {

    private UUID id;

    private Double amount;

    private UUID fromCard;

    private StrategyType type;

    private UUID toCard;

    private UUID toOrganization;
}

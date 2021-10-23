package com.gymteam.backend.account.dto.bff;

import com.gymteam.backend.account.entity.StrategyType;
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

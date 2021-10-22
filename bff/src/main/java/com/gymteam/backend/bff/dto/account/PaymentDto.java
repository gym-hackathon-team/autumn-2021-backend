package com.gymteam.backend.bff.dto.account;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PaymentDto {
    private UUID id;
    private UUID fromAccount;
    private UUID fromCard;
    private UUID toCard;
    private double amount;
}

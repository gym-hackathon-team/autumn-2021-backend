package com.gymteam.backend.bff.dto.account;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter

public class PaymentCreateRequest {

    private double amount;

    private UUID fromCard;

    private AccountType type;

    private UUID toCard;

    private UUID toAccount;
}

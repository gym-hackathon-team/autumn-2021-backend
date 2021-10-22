package com.gymteam.backend.bff.dto.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter

public class PaymentCreateRequest {

    private UUID fromAccount;
    private UUID fromCard;
    private UUID toCard;
    private double amount;
}

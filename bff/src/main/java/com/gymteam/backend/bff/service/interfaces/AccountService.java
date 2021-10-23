package com.gymteam.backend.bff.service.interfaces;

import com.gymteam.backend.bff.dto.account.CardDto;
import com.gymteam.backend.bff.dto.account.PaymentResultStatus;

import java.util.List;
import java.util.UUID;

public interface AccountService {

    PaymentResultStatus createUserTransaction(UUID cardId, String toCard, Double amount);

    PaymentResultStatus createFeePayment(UUID cardId, String toAccount, Double amount);

    List<CardDto> getUserCards();
}

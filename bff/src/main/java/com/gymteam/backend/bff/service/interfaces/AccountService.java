package com.gymteam.backend.bff.service.interfaces;

import com.gymteam.backend.bff.dto.account.*;

import java.util.List;
import java.util.UUID;

public interface AccountService {

    public PaymentDto createPayment(PaymentCreateRequest paymentCreateRequest);

    public CardDto getCard(UUID id);

    public AccountDto getAccount(UUID id);


    public PaymentResultStatus createUserTransaction(UUID id,UUID cardId,String toCard);

    public PaymentResultStatus createFeePayment(UUID id,UUID cardId,UUID toAccount);

    public List<CardDto> getUserCards(UUID id);
}

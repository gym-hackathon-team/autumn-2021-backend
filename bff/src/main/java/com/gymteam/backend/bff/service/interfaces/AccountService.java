package com.gymteam.backend.bff.service.interfaces;

import com.gymteam.backend.bff.dto.account.AccountDto;
import com.gymteam.backend.bff.dto.account.CardDto;
import com.gymteam.backend.bff.dto.account.PaymentCreateRequest;
import com.gymteam.backend.bff.dto.account.PaymentDto;

import java.util.UUID;

public interface AccountService {

    public PaymentDto createPayment(PaymentCreateRequest paymentCreateRequest);

    public CardDto getCard(UUID id);

    public AccountDto getAccount(UUID id);
}

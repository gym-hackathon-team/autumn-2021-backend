package com.gymteam.backend.bff.service.impl;

import com.gymteam.backend.bff.dto.account.AccountDto;
import com.gymteam.backend.bff.dto.account.CardDto;
import com.gymteam.backend.bff.dto.account.PaymentCreateRequest;
import com.gymteam.backend.bff.dto.account.PaymentDto;
import com.gymteam.backend.bff.service.interfaces.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    @Override
    public PaymentDto createPayment(PaymentCreateRequest paymentCreateRequest)
    {
        //Test
        PaymentDto payment=new PaymentDto();
        payment.setId(UUID.randomUUID());
        payment.setFromAccount(paymentCreateRequest.getFromAccount());
        payment.setAmount(paymentCreateRequest.getAmount());
        payment.setFromCard(paymentCreateRequest.getFromCard());
        payment.setToCard(paymentCreateRequest.getToCard());

        return payment;
    }
    @Override
    public CardDto getCard(UUID id)
    {
        //Test
        CardDto card=new CardDto();
        card.setId(id);
        card.setBalance(25477.19);
        card.setAccountId(UUID.randomUUID());
        card.setNumber("4274250025441122");
        return card;
    }
    @Override
    public AccountDto getAccount(UUID id)
    {
        //Test
        AccountDto account=new AccountDto();
        account.setId(id);
        account.setUserId(UUID.randomUUID());
        account.setNumber("55552500254411224444");
        return account;

    }
}

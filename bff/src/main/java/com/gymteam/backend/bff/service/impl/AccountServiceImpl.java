package com.gymteam.backend.bff.service.impl;

import com.gymteam.backend.bff.dto.account.*;
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
        payment.setAmount(paymentCreateRequest.getAmount());
        payment.setFromCard(paymentCreateRequest.getFromCard());
        payment.setType(paymentCreateRequest.getType());
        if(paymentCreateRequest.getType()== AccountType.USER)
        {
            payment.setToCard(paymentCreateRequest.getToCard());
            payment.setToAccount(null);
        }
        if(paymentCreateRequest.getType()== AccountType.ORGANIZATION)
        {
            payment.setToCard(null);
            payment.setToAccount(paymentCreateRequest.getToAccount());
        }

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
        account.setNumber("55552500254411224444");
        account.setType(AccountType.USER);
        account.setUserId(UUID.randomUUID());
        account.setOrganizationId(null);
        account.setBalance(285.99);

        return account;

    }
}

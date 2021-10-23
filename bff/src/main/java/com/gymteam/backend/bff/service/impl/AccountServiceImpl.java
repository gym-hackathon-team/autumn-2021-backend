package com.gymteam.backend.bff.service.impl;

import com.gymteam.backend.bff.dto.account.*;
import com.gymteam.backend.bff.service.interfaces.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {


    @Override
    public PaymentResultStatus createUserTransaction(UUID id,UUID cardId,String toCard)
    {
        //Test
        PaymentResultStatus paymentResultStatus=new PaymentResultStatus();
        paymentResultStatus.setStatus(true);
        return paymentResultStatus;

    }
    @Override
    public PaymentResultStatus createFeePayment(UUID id,UUID cardId,String toAccount)
    {
        //Test
        PaymentResultStatus paymentResultStatus=new PaymentResultStatus();
        paymentResultStatus.setStatus(true);
        return paymentResultStatus;
    }
    @Override
    public List<CardDto> getUserCards(UUID id)
    {
        //Test
        CardDto card=new CardDto();
        card.setId(UUID.randomUUID());
        card.setBalance(65477.29);
        card.setAccountId(UUID.randomUUID());
        card.setNumber("4274254425441122");
        List<CardDto> cards=new ArrayList<>();
        cards.add(card);
        return cards;
    }
}

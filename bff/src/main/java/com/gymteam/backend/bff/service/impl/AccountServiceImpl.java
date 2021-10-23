package com.gymteam.backend.bff.service.impl;

import com.gymteam.backend.bff.client.AccountClient;
import com.gymteam.backend.bff.dto.account.CardDto;
import com.gymteam.backend.bff.dto.account.PaymentResultStatus;
import com.gymteam.backend.bff.security.Authorized;
import com.gymteam.backend.bff.service.interfaces.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountClient accountClient;

    @Override
    public PaymentResultStatus createUserTransaction(UUID cardId, String toCard) {
        Authorized authorized = (Authorized) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // TODO Get ID from this

        //Test
        PaymentResultStatus paymentResultStatus = new PaymentResultStatus();
        paymentResultStatus.setStatus(true);
        return paymentResultStatus;
    }

    @Override
    public PaymentResultStatus createFeePayment(UUID cardId, String toAccount) {
        Authorized authorized = (Authorized) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // TODO Get ID from this

        //Test
        PaymentResultStatus paymentResultStatus = new PaymentResultStatus();
        paymentResultStatus.setStatus(true);
        return paymentResultStatus;
    }

    @Override
    public List<CardDto> getUserCards() {
        Authorized authorized = (Authorized) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // TODO Get ID from this

        //Test
        CardDto card = new CardDto();
        card.setId(UUID.randomUUID());
        card.setBalance(65477.29);
        card.setAccountId(UUID.randomUUID());
        card.setNumber("4274254425441122");
        List<CardDto> cards = new ArrayList<>();
        cards.add(card);
        return cards;
    }
}

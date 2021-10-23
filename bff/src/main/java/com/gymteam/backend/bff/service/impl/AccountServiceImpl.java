package com.gymteam.backend.bff.service.impl;

import com.gymteam.backend.bff.client.AccountClient;
import com.gymteam.backend.bff.dto.account.CardDto;
import com.gymteam.backend.bff.dto.account.PaymentResultStatus;
import com.gymteam.backend.bff.dto.account.TransactionDto;
import com.gymteam.backend.bff.security.Authorized;
import com.gymteam.backend.bff.service.interfaces.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountClient accountClient;

    @Override
    public PaymentResultStatus createUserTransaction(UUID cardId, String toCard, Double amount) {
        Authorized authorized = (Authorized) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Optional<TransactionDto> transaction = accountClient.createUserTransaction(authorized.getId(), cardId, toCard, amount);
        PaymentResultStatus response = new PaymentResultStatus();
        response.setStatus(transaction.isPresent());
        return response;
    }

    @Override
    public PaymentResultStatus createFeePayment(UUID cardId, String toAccount, Double amount) {
        Authorized authorized = (Authorized) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Optional<TransactionDto> transaction = accountClient.createFeePayment(authorized.getId(), cardId, toAccount, amount);
        PaymentResultStatus response = new PaymentResultStatus();
        response.setStatus(transaction.isPresent());
        return response;
    }

    @Override
    public List<CardDto> getUserCards() {
        Authorized authorized = (Authorized) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return accountClient.getUserCards(authorized.getId());
    }
}

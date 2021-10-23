package com.gymteam.backend.account.service.interfaces;

import com.gymteam.backend.account.entity.Transaction;

import java.util.UUID;

public interface TransactionService {

    Transaction createUserTransaction(UUID userId, UUID cardId, String toCard, Double amount);

    Transaction createOrganizationTransaction(UUID userId, UUID cardId, String toAccount, Double amount);
}

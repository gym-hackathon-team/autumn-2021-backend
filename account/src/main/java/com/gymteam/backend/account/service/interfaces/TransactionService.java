package com.gymteam.backend.account.service.interfaces;

import com.gymteam.backend.account.entity.Transaction;
import com.gymteam.backend.account.exception.NotFoundException;

import java.util.UUID;

public interface TransactionService {

    Transaction createUserTransaction(UUID userId, UUID cardId, String toCard, Double amount) throws NotFoundException;

    Transaction createOrganizationTransaction(UUID userId, UUID cardId, String toAccount, Double amount) throws NotFoundException;
}

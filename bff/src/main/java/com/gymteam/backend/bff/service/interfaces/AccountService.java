package com.gymteam.backend.bff.service.interfaces;

import com.gymteam.backend.bff.dto.account.*;

import java.util.List;
import java.util.UUID;

public interface AccountService {


    PaymentResultStatus createUserTransaction(UUID id,UUID cardId,String toCard);

    PaymentResultStatus createFeePayment(UUID id,UUID cardId,String toAccount);

    List<CardDto> getUserCards(UUID id);
}

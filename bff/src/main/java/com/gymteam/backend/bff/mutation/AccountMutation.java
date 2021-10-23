package com.gymteam.backend.bff.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.gymteam.backend.bff.dto.account.PaymentResultStatus;
import com.gymteam.backend.bff.service.interfaces.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class AccountMutation implements GraphQLMutationResolver {

    private final AccountService accountService;

    public PaymentResultStatus createUserTransaction(UUID cardId, String toCard) {
        return accountService.createUserTransaction(cardId, toCard);
    }

    public PaymentResultStatus createFeePayment(UUID cardId, String toAccount) {
        return accountService.createFeePayment(cardId, toAccount);
    }
}

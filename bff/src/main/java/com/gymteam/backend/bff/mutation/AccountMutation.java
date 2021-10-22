package com.gymteam.backend.bff.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.gymteam.backend.bff.dto.account.PaymentCreateRequest;
import com.gymteam.backend.bff.dto.account.PaymentDto;
import com.gymteam.backend.bff.service.interfaces.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class AccountMutation implements GraphQLMutationResolver {

    private final AccountService accountService;

    public PaymentDto createPayment(UUID fromAccount,UUID fromCard, UUID toCard,double amount)
    {
        PaymentCreateRequest paymentCreateRequest=new PaymentCreateRequest();
        paymentCreateRequest.setFromAccount(fromAccount);
        paymentCreateRequest.setFromCard(fromCard);
        paymentCreateRequest.setToCard(toCard);
        paymentCreateRequest.setAmount(amount);
        return accountService.createPayment(paymentCreateRequest);
    }
}

package com.gymteam.backend.bff.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.gymteam.backend.bff.dto.account.AccountType;
import com.gymteam.backend.bff.dto.account.PaymentCreateRequest;
import com.gymteam.backend.bff.dto.account.PaymentDto;
import com.gymteam.backend.bff.dto.account.PaymentResultStatus;
import com.gymteam.backend.bff.service.interfaces.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class AccountMutation implements GraphQLMutationResolver {

    private final AccountService accountService;

    public PaymentDto createPayment(double amount, UUID fromCard, AccountType type,UUID toCard, UUID toAccount)
    {
        PaymentCreateRequest paymentCreateRequest=new PaymentCreateRequest();
        paymentCreateRequest.setAmount(amount);
        paymentCreateRequest.setFromCard(fromCard);
        paymentCreateRequest.setType(type);
        paymentCreateRequest.setToCard(toCard);
        paymentCreateRequest.setToAccount(toAccount);


        return accountService.createPayment(paymentCreateRequest);
    }



    public PaymentResultStatus createUserTransaction(UUID id,UUID cardId,String toCard)
    {return accountService.createUserTransaction(id,cardId,toCard);}

    public PaymentResultStatus createFeePayment(UUID id,UUID cardId,UUID toAccount)
    {return accountService.createFeePayment(id,cardId,toAccount);}
}

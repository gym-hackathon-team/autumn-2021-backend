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

    public PaymentResultStatus createUserTransaction(UUID id,UUID cardId,String toCard)
    {return accountService.createUserTransaction(id,cardId,toCard);}

    public PaymentResultStatus createFeePayment(UUID id,UUID cardId,String toAccount)
    {return accountService.createFeePayment(id,cardId,toAccount);}
}

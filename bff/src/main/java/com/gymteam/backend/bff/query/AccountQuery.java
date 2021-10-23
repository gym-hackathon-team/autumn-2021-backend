package com.gymteam.backend.bff.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.gymteam.backend.bff.dto.account.AccountDto;
import com.gymteam.backend.bff.dto.account.CardDto;
import com.gymteam.backend.bff.service.interfaces.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class AccountQuery implements GraphQLQueryResolver {

    private final AccountService accountService;

    public CardDto getCard(UUID id) {return accountService.getCard(id);}

    public AccountDto getAccount(UUID id) {return accountService.getAccount(id);}


    public List<CardDto> getUserCards(UUID id){return accountService.getUserCards(id);}
}

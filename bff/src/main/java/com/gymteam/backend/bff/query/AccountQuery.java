package com.gymteam.backend.bff.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.gymteam.backend.bff.dto.account.CardDto;
import com.gymteam.backend.bff.service.interfaces.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class AccountQuery implements GraphQLQueryResolver {

    private final AccountService accountService;

    public List<CardDto> getUserCards() {
        return accountService.getUserCards();
    }
}

package com.gymteam.backend.account.service.impl;

import com.gymteam.backend.account.dto.bff.CardDto;
import com.gymteam.backend.account.entity.Account;
import com.gymteam.backend.account.entity.Card;
import com.gymteam.backend.account.mapper.interfaces.CardDtoMapper;
import com.gymteam.backend.account.repository.AccountRepository;
import com.gymteam.backend.account.repository.CardRepository;
import com.gymteam.backend.account.service.interfaces.CardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CardServiceImpl implements CardService {

    private final AccountRepository accountRepository;

    private final CardRepository cardRepository;

    private final CardDtoMapper mapper;

    @Override
    public List<CardDto> getCardsByUserId(UUID userId) {
        Optional<Account> account = accountRepository.findAccountByUserId(userId);

        return account.map(value -> cardRepository.findAllByAccountId(value.getId()).stream().map(mapper::convertToDto).collect(Collectors.toList())).orElse(null);
    }
}

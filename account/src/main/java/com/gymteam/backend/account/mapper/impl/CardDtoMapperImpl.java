package com.gymteam.backend.account.mapper.impl;

import com.gymteam.backend.account.dto.bff.CardDto;
import com.gymteam.backend.account.entity.Card;
import com.gymteam.backend.account.mapper.interfaces.CardDtoMapper;
import org.springframework.stereotype.Service;

@Service
public class CardDtoMapperImpl implements CardDtoMapper {

    @Override
    public Card convertToEntity(CardDto dto) {
        Card entity = new Card();
        entity.setId(dto.getId());
        entity.setBalance(dto.getBalance());
        entity.setNumber(dto.getNumber());
        entity.setAccountId(dto.getAccountId());
        return null;
    }

    @Override
    public CardDto convertToDto(Card entity) {
        CardDto dto = new CardDto();
        dto.setId(entity.getId());
        dto.setBalance(entity.getBalance());
        dto.setNumber(entity.getNumber());
        dto.setAccountId(entity.getAccountId());
        return dto;
    }
}

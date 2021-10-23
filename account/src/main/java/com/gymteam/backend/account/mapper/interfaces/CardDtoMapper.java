package com.gymteam.backend.account.mapper.interfaces;

import com.gymteam.backend.account.dto.bff.CardDto;
import com.gymteam.backend.account.entity.Card;

public interface CardDtoMapper {

    Card convertToEntity(CardDto dto);

    CardDto convertToDto(Card dto);
}

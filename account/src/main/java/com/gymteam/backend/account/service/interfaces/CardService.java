package com.gymteam.backend.account.service.interfaces;

import com.gymteam.backend.account.dto.bff.CardDto;

import java.util.List;
import java.util.UUID;

public interface CardService {

    List<CardDto> getCardsByUserId(UUID userId);
}

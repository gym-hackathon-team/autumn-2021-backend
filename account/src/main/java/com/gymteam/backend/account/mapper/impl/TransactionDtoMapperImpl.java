package com.gymteam.backend.account.mapper.impl;

import com.gymteam.backend.account.dto.bff.CardDto;
import com.gymteam.backend.account.dto.bff.TransactionDto;
import com.gymteam.backend.account.entity.Card;
import com.gymteam.backend.account.entity.Transaction;
import com.gymteam.backend.account.mapper.interfaces.CardDtoMapper;
import com.gymteam.backend.account.mapper.interfaces.TransactionDtoMapper;
import org.springframework.stereotype.Service;

@Service
public class TransactionDtoMapperImpl implements TransactionDtoMapper {

    @Override
    public Transaction convertToEntity(TransactionDto dto) {
        Transaction entity = new Transaction();
        entity.setId(dto.getId());
        entity.setAmount(dto.getAmount());
        entity.setToOrganization(dto.getToOrganization());
        entity.setToCard(dto.getToCard());
        entity.setType(dto.getType());
        entity.setFromCard(dto.getFromCard());
        return null;
    }

    @Override
    public TransactionDto convertToDto(Transaction entity) {
        TransactionDto dto = new TransactionDto();
        dto.setId(entity.getId());
        dto.setAmount(entity.getAmount());
        dto.setToOrganization(entity.getToOrganization());
        dto.setToCard(entity.getToCard());
        dto.setType(entity.getType());
        dto.setFromCard(entity.getFromCard());
        return dto;
    }
}

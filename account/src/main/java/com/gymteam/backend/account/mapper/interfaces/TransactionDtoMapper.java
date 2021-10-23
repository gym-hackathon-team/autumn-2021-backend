package com.gymteam.backend.account.mapper.interfaces;

import com.gymteam.backend.account.dto.bff.CardDto;
import com.gymteam.backend.account.dto.bff.TransactionDto;
import com.gymteam.backend.account.entity.Card;
import com.gymteam.backend.account.entity.Transaction;

public interface TransactionDtoMapper {

    Transaction convertToEntity(TransactionDto dto);

    TransactionDto convertToDto(Transaction entity);
}

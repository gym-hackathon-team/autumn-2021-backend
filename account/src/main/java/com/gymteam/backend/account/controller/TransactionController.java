package com.gymteam.backend.account.controller;

import com.gymteam.backend.account.dto.bff.TransactionDto;
import com.gymteam.backend.account.mapper.interfaces.TransactionDtoMapper;
import com.gymteam.backend.account.service.interfaces.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/transaction")
@AllArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    private final TransactionDtoMapper mapper;

    @PostMapping("/userStrategy")
    public ResponseEntity<TransactionDto> createUserTransaction(@RequestHeader UUID userId, @RequestHeader UUID cardId, @RequestHeader String toCard, @RequestHeader Double amount) {
        try {
            return new ResponseEntity<>(mapper.convertToDto(transactionService.createUserTransaction(userId, cardId, toCard, amount)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/organizationStrategy")
    public ResponseEntity<TransactionDto> createFeePayment(@RequestHeader UUID userId, @RequestHeader UUID cardId, @RequestHeader String toAccount, @RequestHeader Double amount) {
        try {
            return new ResponseEntity<>(mapper.convertToDto(transactionService.createOrganizationTransaction(userId, cardId, toAccount, amount)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

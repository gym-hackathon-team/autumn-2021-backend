package com.gymteam.backend.bff.controller;

import com.gymteam.backend.bff.dto.account.CardDto;
import com.gymteam.backend.bff.dto.account.PaymentResultStatus;
import com.gymteam.backend.bff.service.interfaces.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/request")
@AllArgsConstructor
public class Rest {

    private final AccountService accountService;

    @PostMapping("/createTransaction")
    public PaymentResultStatus createUserTransaction(@RequestHeader UUID cardId, @RequestHeader String toCard) {
        return accountService.createUserTransaction(cardId, toCard);
    }

    @PostMapping("/createPayment")
    public PaymentResultStatus createFeePayment(UUID cardId, String toAccount) {
        return accountService.createFeePayment(cardId, toAccount);
    }

    @GetMapping("/cards")
    public List<CardDto> getUserCards() {
        return accountService.getUserCards();
    }
}

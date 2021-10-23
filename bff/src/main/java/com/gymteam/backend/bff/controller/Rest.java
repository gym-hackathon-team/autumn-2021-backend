package com.gymteam.backend.bff.controller;

import com.gymteam.backend.bff.dto.account.CardDto;
import com.gymteam.backend.bff.dto.account.PaymentResultStatus;
import com.gymteam.backend.bff.service.interfaces.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/request")
@AllArgsConstructor
public class Rest {

    private final AccountService accountService;

    @PostMapping("/createTransaction")
    public ResponseEntity<PaymentResultStatus> createUserTransaction(@RequestHeader UUID cardId, @RequestHeader String toCard) {

        return new ResponseEntity<>(accountService.createUserTransaction(cardId, toCard), HttpStatus.OK);
    }

    @PostMapping("/createPayment")
    public ResponseEntity<PaymentResultStatus> createFeePayment(@RequestHeader UUID cardId,@RequestHeader String toAccount) {

        return new ResponseEntity<>(accountService.createFeePayment(cardId, toAccount), HttpStatus.OK);
    }

    @GetMapping("/cards")
    public ResponseEntity<List<CardDto>> getUserCards() {

        return new ResponseEntity<>(accountService.getUserCards(), HttpStatus.OK);
    }
}

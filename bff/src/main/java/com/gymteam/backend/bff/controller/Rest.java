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
    public ResponseEntity<PaymentResultStatus> createUserTransaction(@RequestHeader UUID cardId, @RequestHeader String toCard, @RequestHeader Double amount) {
        try {
            return new ResponseEntity<>(accountService.createUserTransaction(cardId, toCard, amount), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/createPayment")
    public ResponseEntity<PaymentResultStatus> createFeePayment(@RequestHeader UUID cardId, @RequestHeader String toAccount, @RequestHeader Double amount) {
        try {
            return new ResponseEntity<>(accountService.createFeePayment(cardId, toAccount, amount), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/cards")
    public ResponseEntity<List<CardDto>> getUserCards() {
        try {
            return new ResponseEntity<>(accountService.getUserCards(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

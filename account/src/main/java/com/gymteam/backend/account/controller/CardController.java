package com.gymteam.backend.account.controller;

import com.gymteam.backend.account.dto.bff.CardDto;
import com.gymteam.backend.account.service.interfaces.CardService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/card")
@AllArgsConstructor
public class CardController {

    private final CardService cardService;

    @GetMapping("/")
    public ResponseEntity<List<CardDto>> getUserCards(@RequestHeader UUID userId) {
        try {
            return new ResponseEntity<>(cardService.getCardsByUserId(userId), HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

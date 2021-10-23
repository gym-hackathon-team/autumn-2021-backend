package com.gymteam.backend.bff.controller;

import com.gymteam.backend.bff.dto.account.CardDto;
import com.gymteam.backend.bff.dto.account.PaymentResultStatus;
import com.gymteam.backend.bff.dto.client.VoiceCommandResponse;
import com.gymteam.backend.bff.exception.VoiceNotRegisteredException;
import com.gymteam.backend.bff.service.interfaces.AccountService;
import com.gymteam.backend.bff.service.interfaces.VoiceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/request")
@AllArgsConstructor
public class Rest {

    private final AccountService accountService;

    private final VoiceService voiceService;

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

    @RequestMapping(value = "/voiceCommand", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    public ResponseEntity<VoiceCommandResponse> voiceCommandVerify(@RequestParam("upload_file") MultipartFile multipart) {
        try {
            return new ResponseEntity<>(voiceService.authorizeVoiceCommand(multipart), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/voiceRegister", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    public ResponseEntity<Object> userVoiceRegister(@RequestParam("upload_file") MultipartFile multipart) {
        try {
            voiceService.registerUserVoice(multipart);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (VoiceNotRegisteredException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

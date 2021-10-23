package com.gymteam.backend.bff.client;

import com.gymteam.backend.bff.dto.account.CardDto;
import com.gymteam.backend.bff.dto.account.TransactionDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@FeignClient("account-service")
public interface AccountClient {

    @RequestMapping(value = "/transaction/userStrategy", method = RequestMethod.POST)
    Optional<TransactionDto> createUserTransaction(@RequestHeader UUID userId, @RequestHeader UUID cardId, @RequestHeader String toCard, @RequestHeader Double amount);

    @RequestMapping(value = "/transaction/organizationStrategy", method = RequestMethod.POST)
    Optional<TransactionDto> createFeePayment(@RequestHeader UUID userId, @RequestHeader UUID cardId, @RequestHeader String toAccount, @RequestHeader Double amount);

    @RequestMapping(value = "/card/", method = RequestMethod.POST)
    List<CardDto> getUserCards(@RequestHeader UUID userId);
}

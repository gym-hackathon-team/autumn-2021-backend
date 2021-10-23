package com.gymteam.backend.account.repository;

import com.gymteam.backend.account.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CardRepository extends JpaRepository<Card, UUID> {

    List<Card> findAllByAccountId(UUID accountId);

    Optional<Card> findCardByNumber(String number);
}

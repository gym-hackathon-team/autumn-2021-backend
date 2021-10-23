package com.gymteam.backend.account.repository;

import com.gymteam.backend.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {

    Optional<Account> findAccountByUserId(UUID userId);

    Optional<Account> findAccountByNumber(String number);
}

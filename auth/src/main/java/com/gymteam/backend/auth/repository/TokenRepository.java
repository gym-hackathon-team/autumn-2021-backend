package com.gymteam.backend.auth.repository;

import com.gymteam.backend.auth.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TokenRepository extends JpaRepository<Token, UUID> {
    Optional<Token> findTokenByValue(String value);
}

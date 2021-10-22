package com.gymteam.backend.user.repository;

import com.gymteam.backend.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findUserByEmailAndPassword(String email, String password);
}

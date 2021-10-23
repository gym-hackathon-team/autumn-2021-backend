package com.gymteam.backend.account.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private UUID id;

    @Column(name = "number", unique = true, nullable = false)
    private String number;

    @Enumerated(EnumType.STRING)
    private StrategyType type;

    @Column(name = "user_id")
    private UUID userId; // null if type = ORGANIZATION

    @Column(name = "organization_id")
    private UUID organizationId; // null if type = USER

    @Column(name = "balance")
    private Double balance; // null if type = USER
}

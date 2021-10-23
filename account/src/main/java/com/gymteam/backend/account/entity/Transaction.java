package com.gymteam.backend.account.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private UUID id;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "from_card", nullable = false)
    private UUID fromCard;

    @Enumerated(EnumType.STRING)
    private StrategyType type;

    @Column(name = "to_card")
    private UUID toCard; // null if type = ORGANIZATION

    @Column(name = "to_organization")
    private UUID toOrganization; // null if type = USER
}

package com.gymteam.backend.account.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private UUID id;

    @Column(name = "number", unique = true, nullable = false)
    private String number;

    @Column(name = "balance", nullable = false)
    private Double balance;

    @Column(name = "account_id", nullable = false)
    private UUID accountId;
}

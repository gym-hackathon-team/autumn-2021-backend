package com.gymteam.backend.auth.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "tokens")
public class Token {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private UUID id;

    @Column(name = "value", unique = true, nullable = false)
    private String value;

    @Column(name = "expired", nullable = false)
    private boolean expired;

    @Column(name = "entity_id", nullable = false)
    private UUID entityId;

    @Column(name = "scope", nullable = false)
    private String scope;
}

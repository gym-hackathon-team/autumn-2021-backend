package com.gymteam.backend.bff.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
final public class Book {
    private int id;
    private String title;
    private String author;
    private int year;
}

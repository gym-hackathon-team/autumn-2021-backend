package com.gymteam.backend.bff.model;
//Test
public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.year = year;
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }
}

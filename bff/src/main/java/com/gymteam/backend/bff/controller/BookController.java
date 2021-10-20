package com.gymteam.backend.bff.controller;

import com.gymteam.backend.bff.dto.Book;
import com.gymteam.backend.bff.repository.BookRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {

    @SchemaMapping(typeName="Query", field="getAllBooks")
    public List<Book> getBooks() {
        return BookRepository.getAllBooks();
    }

    @SchemaMapping(typeName="Query", field="getBook")
    public Book getBook(@Argument int id) {
        return BookRepository.getBook(id);
    }
}
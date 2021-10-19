package com.gymteam.backend.bff.controller;

import com.gymteam.backend.bff.dto.Book;
import com.gymteam.backend.bff.repository.BookRepository;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {

    @SchemaMapping(typeName="Query", field="books")
    public List<Book> getBooks() {
        BookRepository books=new BookRepository();
        return books.getAllBooks();
    }
}
package com.gymteam.backend.bff.repository;
import com.gymteam.backend.bff.dto.Book;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;


@Repository
public class BookRepository {

    private final List<Book> books=new ArrayList<>(){{
        add(new Book("1984","Orwell",1949));
        add(new Book("451","451",451));
    }};

    public List<Book> getAllBooks()
    {
        return books;
    }

}
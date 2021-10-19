package com.gymteam.backend.bff.repository;
import com.gymteam.backend.bff.dto.Book;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;


@Repository
public class BookRepository {

    private static final List<Book> books=new ArrayList<>(){{
        add(new Book(1,"1984","Orwell",1949));
        add(new Book(2,"451","451",451));
    }};

    public static List<Book> getAllBooks()
    {
        return books;
    }
    public static Book getBook(int  id)
    {
        return books
                .stream()
                .filter(book->book.getId()==id)
                .findFirst()
                .orElse(null);
    }

}
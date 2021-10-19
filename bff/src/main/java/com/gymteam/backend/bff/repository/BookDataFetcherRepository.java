package com.gymteam.backend.bff.repository;

import com.gymteam.backend.bff.dto.Book;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//Test
@Repository
public class BookDataFetcherRepository implements DataFetcher<List<Book>> {

    @Override
    public List<Book> get(DataFetchingEnvironment DataFetchingEnvironment)
    {
        Book b1984= new Book("1984","Orwell",1949);
        Book b451=new Book("451","451",451);
        List<Book> books= new ArrayList<>();
        books.add(b1984);
        books.add(b451);

        return books;
    }

}
package com.yelemessov.LibraryExample.controllers;

import com.yelemessov.LibraryExample.model.Book;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping(value = "/api")
public class BookController {

    @RequestMapping(value = "/books")
    public List<Book> getAllBooks(){
        List<Book> books = new ArrayList<>();
        Book book = new Book();
        book.setId(UUID.randomUUID());
        book.setTitle("Apache Cassandra");
        book.setYear(2017);
        Set<String> authors = new HashSet<>();
        authors.add("John");
        authors.add("Bret");
        book.setAuthors(authors);
        books.add(book);
        return books;
    }
}

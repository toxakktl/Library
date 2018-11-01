package com.yelemessov.LibraryExample.service;

import com.yelemessov.LibraryExample.model.Book;
import com.yelemessov.LibraryExample.model.BookKey;
import com.yelemessov.LibraryExample.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getBookById(UUID id){
        return bookRepository.findByKeyId(id);
    }

    public Optional<Book> getBookByIdAndTitle(BookKey key){
        return bookRepository.findById(key);
    }

    public Book getBookByTitle(String name){
        return bookRepository.findByKeyTitle(name);
    }

    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    public void deleteBookById(UUID id){
        bookRepository.deleteByKeyId(id);
    }

    public void deleteBookByKey(BookKey key){
        bookRepository.deleteById(key);
    }

}

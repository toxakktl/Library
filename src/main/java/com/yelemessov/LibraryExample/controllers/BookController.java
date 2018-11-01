package com.yelemessov.LibraryExample.controllers;

import com.datastax.driver.core.utils.UUIDs;
import com.yelemessov.LibraryExample.model.Book;
import com.yelemessov.LibraryExample.model.BookKey;
import com.yelemessov.LibraryExample.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api")
public class BookController {

    Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public Book getBookById(@PathVariable(name = "id")UUID id){
        logger.info(id.toString());
        return bookService.getBookById(id);
    }

    @RequestMapping(value = "/book/title/{id}/{title}", method = RequestMethod.GET)
    public Book getBookById(@PathVariable(name = "id") UUID id, @PathVariable(name = "title") String title){
        BookKey key = new BookKey(id, title);
        return bookService.getBookByIdAndTitle(key).isPresent() ? bookService.getBookByIdAndTitle(key).get() : null;
    }

    @RequestMapping(value = "/book/add", method = RequestMethod.POST)
    public Book addBook(@RequestBody Book book){
        book.getKey().setId(UUIDs.random());
        return bookService.addBook(book);
    }

    @RequestMapping(value = "/book/update", method = RequestMethod.POST)
    public Book updateBook(@RequestBody Book book){
        BookKey key = book.getKey();
        Book newBook = null;
        Optional<Book> optionalBook = bookService.getBookByIdAndTitle(key);
        if (optionalBook.isPresent()){
            logger.info("I AM HERE");
            newBook = optionalBook.get();
            if (book.getAuthors() != null)
                newBook.setAuthors(book.getAuthors());
            if (book.getYear() != 0)
                newBook.setYear(book.getYear());
        }else {
            logger.info("I AM THERE");
            book.getKey().setId(UUIDs.random());
            newBook = book;
        }

        return bookService.addBook(newBook);
    }

    @RequestMapping(value = "/book/delete/{id}", method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable(name = "id") UUID id){
        logger.info("Book successfully deleted");
        Book b = bookService.getBookById(id);
        bookService.deleteBookByKey(b.getKey());
        return "Book successfully deleted";
    }
}

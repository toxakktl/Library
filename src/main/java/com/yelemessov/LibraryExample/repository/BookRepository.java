package com.yelemessov.LibraryExample.repository;

import com.yelemessov.LibraryExample.model.Book;
import com.yelemessov.LibraryExample.model.BookKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookRepository extends CassandraRepository<Book, BookKey> {

    Book findByKeyId(UUID id);

    Book findByKeyTitle(String name);

    void deleteByKeyId(UUID id);

}

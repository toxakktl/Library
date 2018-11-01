package com.yelemessov.LibraryExample.model;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Table("books_by_id")
public class Book implements Serializable {

    @PrimaryKey
    private BookKey key;

    private Set<String> authors;
    private int year;

    public Book(BookKey key, Set<String> authors, int year) {
        this.key = key;
        this.authors = authors;
        this.year = year;
    }

    public BookKey getKey() {
        return key;
    }

    public void setKey(BookKey key) {
        this.key = key;
    }

    public Set<String> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<String> authors) {
        this.authors = authors;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


}

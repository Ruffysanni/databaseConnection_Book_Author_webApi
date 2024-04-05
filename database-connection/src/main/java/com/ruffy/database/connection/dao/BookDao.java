package com.ruffy.database.connection.dao;

import com.ruffy.database.connection.domain.Book;

import java.util.Optional;

public interface BookDao {
    void create(Book book);
    Optional<Book> getOneBookByIsbn(String isbn);
}

package com.ruffy.database.connection.dao;

import com.ruffy.database.connection.domain.Author;

import java.util.Optional;

public interface AuthorDao {
    void create(Author author);
    Optional<Author> getOneAuthorById(long authorId);
}

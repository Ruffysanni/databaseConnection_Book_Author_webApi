package com.ruffy.database.connection.dao.implement;

import com.ruffy.database.connection.dao.BookDao;
import com.ruffy.database.connection.domain.Book;
import org.springframework.jdbc.core.JdbcTemplate;

public class BookDaoImplementation implements BookDao {
    private final JdbcTemplate jdbcTemplate;
    public BookDaoImplementation(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create(Book book) {
        jdbcTemplate.update(
                "INSERT INTO books (isbn, title, authorId) VALUES (?, ?, ?)",
                book.getIsbn(), book.getTitle(), book.getAuthorId()
        );
    }
}

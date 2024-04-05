package com.ruffy.database.connection.dao.implement;

import com.ruffy.database.connection.dao.BookDao;
import com.ruffy.database.connection.domain.Author;
import com.ruffy.database.connection.domain.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class BookDaoImplementation implements BookDao {
    private final JdbcTemplate jdbcTemplate;
    public BookDaoImplementation(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    public void create(Book book) {
//        jdbcTemplate.update(
//                "INSERT INTO books (isbn, title, authorId) VALUES (?, ?, ?)",
//                book.getIsbn(), book.getTitle(), book.getAuthorId()
//        );
//    }

    @Override
    public void create(Book book) {
        jdbcTemplate.update(
                "INSERT INTO books (isbn, title, authorId) VALUES (?, ?, ?)",
                book.getIsbn(), book.getTitle(), book.getAuthorId()
        );
    }

    @Override
    public Optional<Book> getOneBookByIsbn(String isbn) {
        List<Book> bookList =  jdbcTemplate.query("SELECT isbn title authorId FROM books WHERE isbn=? LIMIT=1",
                new BookRowMapper(), isbn);
        return bookList.stream().findFirst();
    }

    public static class BookRowMapper implements RowMapper<Book> {
        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Book.builder()
                    .isbn(rs.getString("isbn"))
                    .title(rs.getString("title"))
                    .authorId(rs.getLong("author_id"))
                    .build();
        }
    }
}

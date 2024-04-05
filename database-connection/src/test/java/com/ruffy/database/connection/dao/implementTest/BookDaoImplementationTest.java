package com.ruffy.database.connection.dao.implementTest;


import com.ruffy.database.connection.dao.implement.BookDaoImplementation;
import com.ruffy.database.connection.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookDaoImplementationTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private BookDaoImplementation underTest;

    @Test
    public void testThatCreatedBookGeneratesCorrectSql(){
        Book book = Book.builder()
                .isbn("123-123")
                .authorId(1L)
                .title("The Rich also cry")
                .build();

        underTest.create(book);

        verify(jdbcTemplate).update(
                eq("INSERT INTO books (isbn, title, authorId) VALUES (?, ?, ?)"),
                eq("123-123"),
                eq("The Rich also cry"),
                eq(1L)
        );
    }

    @Test
    public void testThatGetOneBookByIsbnGeneratesTheCorrectSql(){
        underTest.getOneBookByIsbn("123-123");
        verify(jdbcTemplate).query(
                eq("SELECT isbn title authorId FROM books WHERE isbn=? LIMIT=1"),
                ArgumentMatchers.<BookDaoImplementation.BookRowMapper>any(),
                eq("123-123")
        );
    }
}

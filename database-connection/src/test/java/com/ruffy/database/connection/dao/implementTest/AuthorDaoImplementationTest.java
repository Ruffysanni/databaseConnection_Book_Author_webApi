package com.ruffy.database.connection.dao.implementTest;


import com.ruffy.database.connection.dao.AuthorDao;
import com.ruffy.database.connection.dao.implement.AuthorDaoImplementation;
import com.ruffy.database.connection.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AuthorDaoImplementationTest {
    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private AuthorDaoImplementation underTest;

    @Test
    public void testThatCreatedAuthorGeneratesCorrectSql(){
        Author author = Author.builder()
                .id(1L)
                .name("Marylyn Moses")
                .age(23)
                .build();

        underTest.create(author);
        verify(jdbcTemplate).update(
                eq("INSERT INTO authors (id, name, age) VALUES(?, ?, ?)"),
                eq(1L), eq("Marylyn Moses"), eq(23)
        );
    }

    @Test
    public void testThatGetOneAuthorByIdGeneratesTheCorrectSql(){
        underTest.getOneAuthorById(1l);
        verify(jdbcTemplate).query(
                eq("SELECT id name age FROM authors WHERE id = ? LIMIT=1"),
                ArgumentMatchers.<AuthorDaoImplementation.AuthorRowMapper>any(),
                eq(1L)


        );
    }
}

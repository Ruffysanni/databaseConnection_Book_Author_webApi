package com.ruffy.database.connection.dao.implement;

import com.ruffy.database.connection.dao.AuthorDao;
import com.ruffy.database.connection.domain.Author;
import org.springframework.jdbc.core.JdbcTemplate;

public class AuthorDaoImplementation implements AuthorDao {
    private final JdbcTemplate jdbcTemplate;
    public AuthorDaoImplementation(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void create(Author author) {
        jdbcTemplate.update("INSERT INTO authors (id, name, age) VALUES(?, ?, ?)", author.getId(), author.getName(), author.getAge());
    }
}

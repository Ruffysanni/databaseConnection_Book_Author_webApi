package com.ruffy.database.connection.dao.implement;

import com.ruffy.database.connection.dao.AuthorDao;
import com.ruffy.database.connection.domain.Author;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class AuthorDaoImplementation implements AuthorDao {
    private final JdbcTemplate jdbcTemplate;
    public AuthorDaoImplementation(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void create(Author author) {
        jdbcTemplate.update("INSERT INTO authors (id, name, age) VALUES(?, ?, ?)", author.getId(), author.getName(), author.getAge());
    }

    @Override
    public Optional<Author> getOneAuthorById(long authorId) {
        List<Author> authorList =  jdbcTemplate.query("SELECT id name age FROM authors WHERE id = ? LIMIT=1",
                new AuthorRowMapper(), authorId);
        return authorList.stream().findFirst();
    }

    public static class AuthorRowMapper implements RowMapper<Author>{
        @Override
        public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Author.builder()
                    .id(rs.getLong("id"))
                    .name(rs.getString("name"))
                    .age(rs.getInt("age"))
                    .build();
        }
    }
}

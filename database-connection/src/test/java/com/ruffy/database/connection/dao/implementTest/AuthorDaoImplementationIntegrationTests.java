package com.ruffy.database.connection.dao.implementTest;


import com.ruffy.database.connection.TestDataUtility;
import com.ruffy.database.connection.dao.implement.AuthorDaoImplementation;
import com.ruffy.database.connection.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class AuthorDaoImplementationIntegrationTests {
    private AuthorDaoImplementation authorDaoImplementation;

    @Autowired
    public AuthorDaoImplementationIntegrationTests(AuthorDaoImplementation authorDaoImplementation) {
        this.authorDaoImplementation = authorDaoImplementation;
    }

    @Test
    public void testThatAuthorIsCreatedAndCanBeCalled(){
        Author author = TestDataUtility.createTestAuthor();
        authorDaoImplementation.create(author);
        Optional<Author> optionalAuthor =  authorDaoImplementation.getOneAuthorById(author.getId());
        assertThat(optionalAuthor).isPresent();
        assertThat(optionalAuthor.get()).isEqualTo(author);
    }
}

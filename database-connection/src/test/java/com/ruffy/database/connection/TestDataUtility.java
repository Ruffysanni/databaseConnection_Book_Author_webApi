package com.ruffy.database.connection;

import com.ruffy.database.connection.domain.Author;

public final class TestDataUtility {
    private TestDataUtility() {}

    public static Author createTestAuthor() {
        return Author.builder()
                .id(1L)
                .name("Marylyn Moses")
                .age(23)
                .build();
    }
}

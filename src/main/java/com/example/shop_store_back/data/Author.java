package com.example.shop_store_back.data;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public record Author (String id, String firstName, String lastName) {

    private static List<Author> authors = Arrays.asList(
            new Author("author-1", "Joshua", "Bloch"),
            new Author("author-2", "Douglas", "Adams"),
            new Author("author-3", "Bill", "Bryson")
    );

    public static Optional<Author> getById(String id) {
        return authors.stream()
                .filter(author -> author.id().equals(id))
                .findFirst();
//                ;.orElse(null)
    }
}
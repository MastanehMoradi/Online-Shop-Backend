package com.example.shop_store_back.data;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public record Book (String id, String name, int pageCount, String authorId) {

    public static List<Book> books = Arrays.asList(
            new Book("book-1", "Effective Java", 416, "author-1"),
            new Book("book-2", "Hitchhiker's Guide to the Galaxy", 208, "author-2"),
            new Book("book-3", "Down Under", 436, "author-3")
    );

    public static Optional<Book> getById(String id) {
        return books.stream()
                .filter(book -> book.id().equals(id))
                .findFirst();
               // .orElse(null);
    }
}
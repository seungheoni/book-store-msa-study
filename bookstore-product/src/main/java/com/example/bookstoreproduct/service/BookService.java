package com.example.bookstoreproduct.service;

import com.example.database.entity.Book;

public interface BookService {
    Book bookRegistry(Book book);
    Boolean purchaseBook(Long id, Long quantity);
}

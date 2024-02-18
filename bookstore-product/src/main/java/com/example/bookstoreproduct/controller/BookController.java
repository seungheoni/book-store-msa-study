package com.example.bookstoreproduct.controller;

import com.example.bookstoreproduct.service.BookService;
import com.example.database.entity.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    // 생성자를 통한 의존성 주입
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Book> bookRegistry(@RequestBody Book book) {
        Book savedBook = bookService.bookRegistry(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/purchase")
    public ResponseEntity<HttpStatus> purchaseBook(@PathVariable Long id, @RequestParam Long quantity) {
        Boolean purchaseSuccess = bookService.purchaseBook(id, quantity);
        if (purchaseSuccess) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}

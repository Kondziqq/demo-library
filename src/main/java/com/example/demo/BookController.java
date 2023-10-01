package com.example.demo;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/in-database/books")
@RequiredArgsConstructor
class BookController {

    private final BookRepository bookRepository;

    @GetMapping
    List<BookEntity> findAll() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    BookEntity findById(@PathVariable Long id) {
        return bookRepository.findById(id).orElseThrow();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void save(@RequestBody BookEntity book) {
        bookRepository.save(book);
    }

    @DeleteMapping
    void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @GetMapping("/filter")
    List<BookEntity> findByAuthor(@RequestParam String author) {
        return bookRepository.findByAuthor(author);
    }
}

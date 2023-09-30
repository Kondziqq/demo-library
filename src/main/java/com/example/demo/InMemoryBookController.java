package com.example.demo;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/in-memory/books")
@RequiredArgsConstructor
class InMemoryBookController {

    private final InMemoryBookRepository inMemoryBookRepository;

    @GetMapping
    List<BookEntity> findAll() {
        return inMemoryBookRepository.findAll();
    }

    @GetMapping("/{id}")
    BookEntity findById(@PathVariable Long id) {
        return inMemoryBookRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void save(@RequestBody BookEntity book) {
        inMemoryBookRepository.save(book);
    }

    @DeleteMapping
    void deleteById(Long id) {
        inMemoryBookRepository.deleteById(id);
    }

    @GetMapping("/filter")
    List<BookEntity> findByAuthor(@RequestParam String author) {
        return inMemoryBookRepository.findByAuthor(author);
    }
}

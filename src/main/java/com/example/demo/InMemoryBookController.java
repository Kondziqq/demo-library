package com.example.demo;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    void deleteById(Long id) {
        // TODO homework
        // bookRepository.delete(id);
    }

    List<BookEntity> findByAuthor(String author) {
        // TODO homework
        return null;
    }
}

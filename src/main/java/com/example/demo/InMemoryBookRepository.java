package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
class InMemoryBookRepository  {
    private List<BookEntity> books = new ArrayList<>(List.of(
            BookEntity.builder().id(1L).title("W pustyni i w puszczy").author("Henryk Sienkiewicz").build(),
            BookEntity.builder().id(2L).title("Ojciec Chrzestny").author("Mario Puzo").build(),
            BookEntity.builder().id(3L).title("Lalka").author("Bolesław Prus").build()
    ));

    public List<BookEntity> findAll() {
        return books;
    }

    public BookEntity findById(Long id) {
        return books.stream().filter(book -> id.equals(book.getId())).findFirst().orElseThrow();
    }

    public void save(BookEntity book) {
        var newId = books.stream().map(BookEntity::getId).max(Comparator.naturalOrder()).orElseThrow();
        book.setId(++newId);
        books.add(book);
    }
    public List<BookEntity> findByAuthor(String author) {
        return books.stream().filter(book -> author.equals(book.getAuthor())).collect(Collectors.toList());
    }
    public void deleteById (Long id){
        BookEntity bookToBeDeleted = books.stream().filter(book -> id.equals(book.getId())).findFirst().orElseThrow();
        books.remove(bookToBeDeleted);
    }

}

package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "Books")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookEntity {

    @Id
    @GeneratedValue
    Long id;
    String title;
    String author;
}

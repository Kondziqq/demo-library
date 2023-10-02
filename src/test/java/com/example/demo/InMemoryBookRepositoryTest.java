package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
class InMemoryBookRepositoryTest {

    @InjectMocks
    private InMemoryBookRepository inMemoryBookRepository;

    @Test
    void shouldFindById() {
        // given
        var id = 1L;

        // when
        var response = inMemoryBookRepository.findById(id);

        // then
        assertThat(response).isNotNull();
        assertThat(response.title).isEqualTo("W pustyni i w puszczy");
    }

    @Test
    void shouldThrowExceptionWhenThereIsNoBookWithGivenId() {
        // given
        var id = 100L;

        // when
        assertThatThrownBy(() -> inMemoryBookRepository.findById(id))
                .isInstanceOf(NoSuchElementException.class);

        // then
        // nothing to do
    }

    @Test
    void shouldFindAll() {
        // given
        // nothing to do

        // when
        var response = inMemoryBookRepository.findAll();

        // then
        assertThat(response).hasSize(3);
    }

}
package com.example.demo.utils;

import com.example.demo.entity.Books;
import com.example.demo.entity.Publishers;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Helper {

    public List<Books> getBooks() {
        return List.of(
                Books.builder()
                        .id(1L)
                        .title("Book1")
                        .description("description")
                        .category("category")
                        .publisher( Publishers.builder()
                                .id(1L)
                                .name("Publisher1")
                                .address("Address")
                                .books(List.of())
                                .build())
                        .build(),
                Books.builder()
                        .id(1L)
                        .title("Book1")
                        .description("description")
                        .category("category")
                        .publisher( Publishers.builder()
                                .id(1L)
                                .name("Publisher1")
                                .address("Address")
                                .books(List.of())
                                .build())
                        .build()
        );
    }

    public List<Publishers> getPublishers() {
        return List.of(
                Publishers.builder()
                        .id(1L)
                        .name("Publisher1")
                        .address("Address")
                        .books(getBooks())
                        .build(),
                Publishers.builder()
                        .id(2L)
                        .name("Publisher2")
                        .address("Address")
                        .books(getBooks())
                        .build()
        );
    }
}

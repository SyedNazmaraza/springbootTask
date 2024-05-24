package com.example.demo.model;

import com.example.demo.entity.Books;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublisherRequest {
    @NotEmpty
    private String name;
    private String address;
    private List<BookRequest> books;
}

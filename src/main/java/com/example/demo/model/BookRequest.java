package com.example.demo.model;

import lombok.*;

@Getter
@Setter
@Builder
public class BookRequest {
    private String title;
    private String description;
    private String category;
    private Long publisherId;
}

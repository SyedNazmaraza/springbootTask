package com.example.demo.model;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductsRequest {
    @NotEmpty(message = "Name must not be empty")
    private String name;
    private String description;
    private int price;
    private int quantity;
}

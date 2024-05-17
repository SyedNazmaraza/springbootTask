package com.example.demo.controller;

import com.example.demo.model.BaseResponse;
import com.example.demo.model.ProductsRequest;
import com.example.demo.service.ProductsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductsService productsService;

    @GetMapping("/get")
    public ResponseEntity<BaseResponse> getAllProducts() {
        return ResponseEntity.ok(productsService.getAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<BaseResponse> getProductsById(@PathVariable("id") int id) {
        return ResponseEntity.ok(productsService.getProductById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<BaseResponse> createProducts(@RequestBody @Valid ProductsRequest productsRequest) {
        return ResponseEntity.ok(productsService.addProduct(productsRequest));
    }

    @PutMapping("/update{id}")
    public ResponseEntity<BaseResponse> updateProducts(@PathVariable("id") int id, @RequestBody @Valid ProductsRequest productsRequest) {
        return ResponseEntity.ok(productsService.updateProduct(id,productsRequest));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<BaseResponse> deleteProducts() {
        return ResponseEntity.ok(productsService.deleteProducts());
    }

    @DeleteMapping("/delete{id}")
    public ResponseEntity<BaseResponse> deleteById(@PathVariable("id") int id) {
        return ResponseEntity.ok(productsService.deleteProductById(id));
    }
}

package com.example.demo.controller;

import com.example.demo.model.BaseResponse;
import com.example.demo.model.ProductsRequest;
import com.example.demo.service.ProductsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        return new ResponseEntity<>(
                productsService.getProductById(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/create")
    public ResponseEntity<BaseResponse> createProducts(@RequestBody @Valid ProductsRequest productsRequest) {
        return new ResponseEntity<>(
                productsService.addProduct(productsRequest),
                HttpStatus.CREATED
        );
    }


    @PutMapping("/update{id}")
    public ResponseEntity<BaseResponse> updateProducts(@PathVariable("id") int id, @RequestBody @Valid ProductsRequest productsRequest) {
        return new ResponseEntity<>(
                productsService.updateProduct(id,productsRequest),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/delete")
    public ResponseEntity<BaseResponse> deleteProducts() {
        return new ResponseEntity<>(
                productsService.deleteProducts(),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/delete{id}")
    public ResponseEntity<BaseResponse> deleteById(@PathVariable("id") int id) {
        return new ResponseEntity<>(
                productsService.deleteProductById(id),
                HttpStatus.OK
        );
    }
}

package com.example.demo.service;

import com.example.demo.entity.Products;
import com.example.demo.model.BaseResponse;
import com.example.demo.model.ProductsRequest;
import com.example.demo.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsServiceImp implements ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public BaseResponse getAll() {
        List<Products> productsList = productsRepository.findAll();
        return BaseResponse.builder()
                .status("0")
                .message("Products found")
                .data(productsList)
                .build();
    }

    @Override
    public BaseResponse getProductById(int productId) {
        Optional<Products> product = productsRepository.findById(productId);
        if (product.isPresent()) {
            return BaseResponse.builder()
                    .status("0")
                    .message("Product found")
                    .data(product)
                    .build();
        }
        return BaseResponse.builder()
                .status("1")
                .message("Product not found")
                .build();
    }

    @Override
    public BaseResponse addProduct(ProductsRequest request) {
        Products product = productsRepository.save(
                Products.builder()
                        .name(request.getName())
                        .description(request.getDescription())
                        .price(request.getPrice())
                        .quantity(request.getQuantity())
                        .build()
        );
        return BaseResponse.builder()
                .status("0")
                .message("Product added")
                .data(product.getId())
                .build();
    }

    @Override
    public BaseResponse updateProduct(int id, ProductsRequest request) {
        Optional<Products> product = productsRepository.findById(id);
        if (product.isEmpty()) {
            return BaseResponse.builder()
                    .status("1")
                    .message("Product not found")
                    .build();
        }
        productsRepository.deleteById(id);
        productsRepository.save(
                Products.builder()
                        .id(id)
                        .name(request.getName())
                        .description(request.getDescription())
                        .price(request.getPrice())
                        .quantity(request.getQuantity())
                        .build()
        );
        return BaseResponse.builder()
                .status("0")
                .message("Product updated")
                .data(request)
                .build();
    }

    @Override
    public BaseResponse deleteProductById(int productId) {
        productsRepository.deleteById(productId);
        return BaseResponse.builder()
                .status("0")
                .message("Product deleted")
                .build();
    }

    @Override
    public BaseResponse deleteProducts() {
        productsRepository.deleteAll();
        return BaseResponse.builder()
                .status("0")
                .message("Product deleted")
                .build();
    }
}

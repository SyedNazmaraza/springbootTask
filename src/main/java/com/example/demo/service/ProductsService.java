package com.example.demo.service;

import com.example.demo.entity.Products;
import com.example.demo.model.BaseResponse;
import com.example.demo.model.ProductsRequest;

public interface ProductsService {
    BaseResponse getAll();
    BaseResponse getProductById(int productId);

    BaseResponse addProduct(ProductsRequest request);

    BaseResponse updateProduct(int id, ProductsRequest request);

    BaseResponse deleteProductById(int productId);
    BaseResponse deleteProducts();

    BaseResponse getProductLessThanPrice(Double price);
}

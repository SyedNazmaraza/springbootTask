package com.example.demo.service;

import com.example.demo.model.BaseResponse;
import com.example.demo.model.BookRequest;

public interface BooksService {
    BaseResponse createBook(BookRequest bookRequest);
    BaseResponse getAllBooks();

    BaseResponse getBookById(Long id);
    BaseResponse updateBook(Long id, BookRequest bookRequest);
    BaseResponse deleteBook(Long id);
}

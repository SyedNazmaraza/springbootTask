package com.example.demo.controller;

import com.example.demo.model.BaseResponse;
import com.example.demo.model.BookRequest;
import com.example.demo.model.PublisherRequest;
import com.example.demo.service.BooksService;
import com.example.demo.service.PublisherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library")
public class LibraryManagementController {
    @Autowired
    PublisherService publisherService;
    @Autowired
    BooksService bookService;

    @PostMapping("/publishers")
    public ResponseEntity<BaseResponse> addPublisher(@RequestBody @Valid PublisherRequest publisherRequest) {
        return new ResponseEntity<>(
                publisherService.createPublisher(publisherRequest),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/publishers")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<BaseResponse> getPublishers() {
        return new ResponseEntity<>(
                publisherService.getPublishers(),
                HttpStatus.OK
        );
    }

    @GetMapping("/publishers/{publisherId}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<BaseResponse> getPublishersbyId(@PathVariable Long publisherId) {
        return new ResponseEntity<>(
                publisherService.getPublisherById(publisherId),
                HttpStatus.OK
        );
    }

    @PutMapping("/publishers/{publisherId}")
    public ResponseEntity<BaseResponse> updatePublisher(@PathVariable String publisherId, @RequestBody @Valid PublisherRequest publisherRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(publisherService.updatePublisher(Long.parseLong(publisherId), publisherRequest));
    }

    @DeleteMapping("/publisher/{publisherId}")
    public ResponseEntity<BaseResponse> deletePublisher(@PathVariable Long publisherId) {
        return new ResponseEntity<>(
                publisherService.deletePublisher(publisherId),
                HttpStatus.OK
        );
    }

    @PostMapping("/books")
    public ResponseEntity<BaseResponse> addBook(@RequestBody @Valid BookRequest bookRequest) {
        return new ResponseEntity<>(
                bookService.createBook(bookRequest),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/books")
    public ResponseEntity<BaseResponse> getBooks() {
        return new ResponseEntity<>(
                bookService.getAllBooks(),
                HttpStatus.OK
        );
    }

    @GetMapping("/books/{bookId}")
    public ResponseEntity<BaseResponse> getBooksById(@PathVariable Long bookId) {
        return new ResponseEntity<>(
                bookService.getBookById(bookId),
                HttpStatus.OK
        );
    }

    @PutMapping("/books/{bookId}")
    public ResponseEntity<BaseResponse> updateBook(@PathVariable Long bookId, @RequestBody @Valid BookRequest bookRequest) {
        return new ResponseEntity<>(
                bookService.updateBook(bookId, bookRequest),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<BaseResponse> deleteBook(@PathVariable Long bookId) {
        return new ResponseEntity<>(
                bookService.deleteBook(bookId),
                HttpStatus.OK
        );
    }

}

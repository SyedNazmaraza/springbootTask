package com.example.demo.service;

import com.example.demo.entity.Books;
import com.example.demo.entity.Publishers;
import com.example.demo.model.BaseResponse;
import com.example.demo.model.BookRequest;
import com.example.demo.repository.BooksRepository;
import com.example.demo.repository.PublishersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BooksServiceImp implements BooksService {
    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private PublishersRepository publishersRepository;

    @Override
    public BaseResponse createBook(BookRequest bookRequest) {
        Optional<Publishers> publisher = publishersRepository.findById(bookRequest.getPublisherId());
        if (publisher.isPresent()) {
            Books book = booksRepository.save(
                    Books.builder()
                            .title(bookRequest.getTitle())
                            .description(bookRequest.getDescription())
                            .category(bookRequest.getCategory())
                            .publisher(publisher.get())
                            .build()
            );
            return BaseResponse.builder()
                    .status("0")
                    .message("created")
                    .data(book)
                    .build();
        }
        return BaseResponse.builder()
                .status("1")
                .message("publisher not found")
                .build();
    }

    @Override
    public BaseResponse getAllBooks() {
        List<Books> books = booksRepository.findAll();
        return BaseResponse.builder()
                .status("0")
                .message("success")
                .data(books)
                .build();
    }

    @Override
    public BaseResponse getBookById(Long id) {
        Optional<Books> books = booksRepository.findById(id);
        if (books.isPresent()) {
            return BaseResponse.builder()
                    .status("0")
                    .message("success")
                    .data(books)
                    .build();
        }
        return BaseResponse.builder()
                .status("1")
                .message("not found")
                .build();
    }

    @Override
    public BaseResponse updateBook(Long id, BookRequest bookRequest) {
        Optional<Books> books = booksRepository.findById(id);
        if (books.isPresent()) {
            Books book = books.get();
            book.setTitle(bookRequest.getTitle());
            book.setDescription(bookRequest.getDescription());
            book.setCategory(bookRequest.getCategory());
            return BaseResponse.builder()
                    .status("0")
                    .message("success")
                    .data(booksRepository.save(book))
                    .build();
        }
        return BaseResponse.builder()
                .status("1")
                .message("not found")
                .build();
    }

    @Override
    public BaseResponse deleteBook(Long id) {

        Optional<Books> books = booksRepository.findById(id);
        if (books.isPresent()) {
            booksRepository.deleteById(id);
            return BaseResponse.builder()
                    .status("0")
                    .message("success")
                    .data(books.get())
                    .build();
        }
        return BaseResponse.builder()
                .status("1")
                .message("not found")
                .build();

    }
}

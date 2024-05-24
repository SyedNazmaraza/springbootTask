package com.example.demo.service;

import com.example.demo.entity.Books;
import com.example.demo.entity.Publishers;
import com.example.demo.model.BaseResponse;
import com.example.demo.model.BookRequest;
import com.example.demo.model.PublisherRequest;
import com.example.demo.repository.PublishersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
public class PublishersServiceImp implements PublisherService {
    @Autowired
    private PublishersRepository publishersRepository;

    @Override
    public BaseResponse createPublisher(PublisherRequest request) {
        Publishers publisher =
                Publishers.builder()
                        .name(request.getName())
                        .address(request.getAddress())
                        .build();

        for (BookRequest i : request.getBooks()) {
            Books books = Books.builder()
                    .title(i.getTitle())
                    .description(i.getDescription())
                    .category(i.getCategory())
                    .build();
            publisher.addBook(books);
        }
        publishersRepository.save(publisher);
        return BaseResponse.builder()
                .status("0")
                .message("created")
                .data(publisher)
                .build();
    }

    @Override
    public BaseResponse updatePublisher(Long id, PublisherRequest request) {
        Optional<Publishers> publishers = publishersRepository.findById(id);
        if (publishers.isPresent()) {
            Publishers publisher = publishers.get();
            publisher.setName(request.getName());
            publisher.setAddress(request.getAddress());
            return BaseResponse.builder()
                    .status("0")
                    .message("success")
                    .data(publishersRepository.save(publisher))
                    .build();
        }
        return BaseResponse.builder()
                .status("1")
                .message("not found")
                .build();
    }

    @Override
    public BaseResponse deletePublisher(PublisherRequest request) {
        return null;
    }

    @Override
    public BaseResponse getPublishers() {
        List<Publishers> publishers = publishersRepository.findAll();
        return BaseResponse.builder()
                .status("0")
                .message("success")
                .data(publishers)
                .build();
    }

    @Override
    public BaseResponse getPublisherById(Long id) {
        Optional<Publishers> publishers = publishersRepository.findById(id);
        if (publishers.isPresent()) {
            return BaseResponse.builder()
                    .status("0")
                    .message("success")
                    .data(publishers)
                    .build();
        }
        return BaseResponse.builder()
                .status("1")
                .message("not found")
                .build();
    }

    @Override
    public BaseResponse deletePublisher(Long id) {
        Optional<Publishers> publishers = publishersRepository.findById(id);
        if (publishers.isPresent()) {
            publishersRepository.deleteById(id);
            return BaseResponse.builder()
                    .status("0")
                    .message("success")
                    .data(publishers.get())
                    .build();
        }
        return BaseResponse.builder()
                .status("1")
                .message("not found")
                .build();
    }
}

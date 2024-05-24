package com.example.demo.service;

import com.example.demo.model.BaseResponse;
import com.example.demo.model.PublisherRequest;

public interface PublisherService {
    BaseResponse createPublisher(PublisherRequest request);
    BaseResponse updatePublisher(Long id , PublisherRequest request);
    BaseResponse deletePublisher(PublisherRequest request);
    BaseResponse getPublishers();
    BaseResponse getPublisherById(Long id);
    BaseResponse deletePublisher(Long id);
}

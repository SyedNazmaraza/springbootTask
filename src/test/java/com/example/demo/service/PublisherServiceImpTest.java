package com.example.demo.service;

import com.example.demo.repository.ProductsRepository;
import com.example.demo.repository.PublishersRepository;
import com.example.demo.utils.Helper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class PublisherServiceImpTest {

    @MockBean
    private PublishersRepository productsRepository;

    @InjectMocks
    private PublishersServiceImp productsServiceImp;

    @Autowired
    private Helper helper;

    @Test
    public void getAllTest() throws Exception {
        when(productsRepository.findAll()).thenReturn(helper.getPublishers());
        assertEquals(1, productsServiceImp.getPublishers().getData().size());
    }

}
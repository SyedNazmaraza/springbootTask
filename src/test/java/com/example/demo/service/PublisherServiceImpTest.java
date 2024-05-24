package com.example.demo.service;

import com.example.demo.entity.Products;
import com.example.demo.model.BaseResponse;
import com.example.demo.repository.ProductsRepository;
import com.example.demo.repository.PublishersRepository;
import com.example.demo.utils.Helper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
class PublisherServiceImpTest {
    @Mock
    private PublishersRepository productsRepository;

    @InjectMocks
    private PublishersServiceImp productsServiceImp;

    @Autowired
    private Helper helper;

    @Test
    public void getAllTest() throws Exception {
        when(productsRepository.findAll()).thenReturn(helper.getPublishers());
        List<Products> productsList = (List<Products>)productsServiceImp.getPublishers().getData();
        assertEquals(2,productsList.size() );
    }

}
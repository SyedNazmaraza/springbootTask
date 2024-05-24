package com.example.demo.controller;

import com.example.demo.entity.Publishers;
import com.example.demo.repository.PublishersRepository;
import com.example.demo.utils.Helper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static java.lang.reflect.Array.get;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
class LibraryManagementControllerTest {
    @InjectMocks
    private LibraryManagementController libraryManagementController;
    @Mock
    private PublishersRepository publishersRepository;

    @Autowired
    private Helper helper;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.libraryManagementController).build();
    }

    @Test
    public void getPublishers() throws Exception {
        List<Publishers> publishers = helper.getPublishers();
        when(publishersRepository.findAll()).thenReturn(publishers);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/library/publishers")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
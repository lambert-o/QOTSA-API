package com.base.controller;

import com.base.configuration.TestConfig;
import com.base.repository.MyDatabaseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = TestConfig.class)
public class HelloWorldControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnValidResponseWhenRequestValid() throws Exception {
        String name = "Owen Lambert";
        mockMvc.perform(get("/v1/my-controller/hello")
                        .param("name", name))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.response").value("Hello, Owen Lambert"));
    }
}

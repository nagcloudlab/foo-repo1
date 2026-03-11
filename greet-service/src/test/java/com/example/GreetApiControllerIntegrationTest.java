package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GreetApiControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void hello_returnsGreeting() throws Exception {
        mockMvc.perform(get("/api/hello/Alice"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, Alice!"));
    }

    @Test
    void hello_withDifferentName() throws Exception {
        mockMvc.perform(get("/api/hello/Bob"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, Bob!"));
    }

    @Test
    void hello_withNumericName() throws Exception {
        mockMvc.perform(get("/api/hello/123"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, 123!"));
    }

    @Test
    void hello_invalidPath_returns404() throws Exception {
        mockMvc.perform(get("/api/hello"))
                .andExpect(status().isNotFound());
    }
}

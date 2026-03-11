package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GreetServiceTest {

    private final GreetService greetService = new GreetService();

    @Test
    void greet_returnsHelloWithName() {
        String result = greetService.greet("Alice");
        assertEquals("Hello, Alice!", result);
    }

    @Test
    void greet_returnsHelloWithDifferentName() {
        String result = greetService.greet("Bob");
        assertEquals("Hello, Bob!", result);
    }

    @Test
    void greet_withEmptyName() {
        String result = greetService.greet("");
        assertEquals("Hello, !", result);
    }

    @Test
    void greet_returnsNonNullResult() {
        String result = greetService.greet("Test");
        assertNotNull(result);
    }
}

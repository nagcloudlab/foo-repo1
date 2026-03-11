package com.example;

import org.springframework.stereotype.Service;

@Service
public class GreetService {

    public String greet(String name) {
        return "Hello, " + name + "!";
    }

}
